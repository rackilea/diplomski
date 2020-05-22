import org.eclipse.wst.sse.core.internal.provisional.IModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMDocument;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;
import org.eclipse.jface.text.IDocument;
import org.w3c.dom.Element;
...
IModelManager modelManager = StructuredModelManager.getModelManager();
IDOMModel model = null;
try {
    model = (IDOMModel) modelManager.getModelForEdit(anIFile);
    // W3C-like DOM manipulation
    IDOMDocument doc = model.getDocument();
    Element ele = doc.createElement(HTML40Namespace.ElementName.P);
    doc.appendChild(ele);
    // JFace IDocument compatibility
    IDocument textDocument = model.getStructuredDocument();
    textDocument .replace(0, textDocument .getLength(), "<tag>some text</tag>");
    Element ele2 = doc.createElement(HTML40Namespace.ElementName.P);
    doc.appendChild(ele2);
    /* You can do more with either, or both, mechanisms here. DOM
     * changes are reflected in the text immediately and vice versa,
     * with a best effort by the DOM side if the source itself is
     * "broken".
     */
}
finally {
    if (model != null) {
        model.save();
        model.releaseFromEdit();
    }
}