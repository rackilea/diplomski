package org.jsoup.safety;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public class CustomCleaner {
    private Whitelist whitelist;

    public CustomCleaner(Whitelist whitelist) {
    Validate.notNull(whitelist);
    this.whitelist = whitelist;
    }

    public Document clean(Document dirtyDocument) {
    Validate.notNull(dirtyDocument);

    Document clean = Document.createShell(dirtyDocument.baseUri());
    copyDocType(dirtyDocument, clean);
    if (dirtyDocument.head() != null) 
        copySafeNodes(dirtyDocument.head(), clean.head());
    if (dirtyDocument.body() != null) // frameset documents won't have a body. the clean doc will have empty body.
        copySafeNodes(dirtyDocument.body(), clean.body());

    return clean;
    }

    private void copyDocType(Document dirtyDocument, Document clean) {
    dirtyDocument.traverse(new NodeVisitor() {
        public void head(Node node, int depth) {
        if (node instanceof DocumentType) {
            clean.prependChild(node);
        }
        }
        public void tail(Node node, int depth) { }
    });
    }

    public boolean isValid(Document dirtyDocument) {
    Validate.notNull(dirtyDocument);

    Document clean = Document.createShell(dirtyDocument.baseUri());
    int numDiscarded = copySafeNodes(dirtyDocument.body(), clean.body());
    return numDiscarded == 0;
    }

    private final class CleaningVisitor implements NodeVisitor {
    private int numDiscarded = 0;
    private final Element root;
    private Element destination; // current element to append nodes to

    private CleaningVisitor(Element root, Element destination) {
        this.root = root;
        this.destination = destination;
    }

    public void head(Node source, int depth) {
        if (source instanceof Element) {
        Element sourceEl = (Element) source;

        if (whitelist.isSafeTag(sourceEl.tagName())) { // safe, clone and copy safe attrs
            ElementMeta meta = createSafeElement(sourceEl);
            Element destChild = meta.el;
            destination.appendChild(destChild);

            numDiscarded += meta.numAttribsDiscarded;
            destination = destChild;
        } else if (source != root) { // not a safe tag, so don't add. don't count root against discarded.
            numDiscarded++;
        }
        } else if (source instanceof TextNode) {
        TextNode sourceText = (TextNode) source;
        TextNode destText = new TextNode(sourceText.getWholeText(), source.baseUri());
        destination.appendChild(destText);
        } else if (source instanceof Comment) {
        Comment sourceComment = (Comment) source;
        Comment destComment = new Comment(sourceComment.getData(), source.baseUri());
        destination.appendChild(destComment);
        } else if (source instanceof DataNode) {
        DataNode sourceData = (DataNode) source;
        DataNode destData = new DataNode(sourceData.getWholeData(), source.baseUri());
        destination.appendChild(destData);
        } else { // else, we don't care about comments, xml proc instructions, etc
        numDiscarded++;
        }
    }

    public void tail(Node source, int depth) {
        if (source instanceof Element && whitelist.isSafeTag(source.nodeName())) {
        destination = destination.parent(); // would have descended, so pop destination stack
        }
    }
    }

    private int copySafeNodes(Element source, Element dest) {
    CleaningVisitor cleaningVisitor = new CleaningVisitor(source, dest);
    NodeTraversor traversor = new NodeTraversor(cleaningVisitor);
    traversor.traverse(source);
    return cleaningVisitor.numDiscarded;
    }

    private ElementMeta createSafeElement(Element sourceEl) {
    String sourceTag = sourceEl.tagName();
    Attributes destAttrs = new Attributes();
    Element dest = new Element(Tag.valueOf(sourceTag), sourceEl.baseUri(), destAttrs);
    int numDiscarded = 0;

    Attributes sourceAttrs = sourceEl.attributes();
    for (Attribute sourceAttr : sourceAttrs) {
        if (whitelist.isSafeAttribute(sourceTag, sourceEl, sourceAttr))
        destAttrs.put(sourceAttr);
        else
        numDiscarded++;
    }
    Attributes enforcedAttrs = whitelist.getEnforcedAttributes(sourceTag);
    destAttrs.addAll(enforcedAttrs);

    return new ElementMeta(dest, numDiscarded);
    }

    private static class ElementMeta {
    Element el;
    int numAttribsDiscarded;

    ElementMeta(Element el, int numAttribsDiscarded) {
        this.el = el;
        this.numAttribsDiscarded = numAttribsDiscarded;
    }
    }

}