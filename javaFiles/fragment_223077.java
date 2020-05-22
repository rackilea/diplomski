import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.w3c.dom.Document;

public class XPathFragmentAdapter extends XmlAdapter<String, XPathFragment>{

    private Document document;

    public XPathFragmentAdapter() {
    }

    public XPathFragmentAdapter(Document document) {
        this.document = document;
    }

    @Override
    public XPathFragment unmarshal(String v) throws Exception {
        XPathFragment xPathFragment = new XPathFragment();
        xPathFragment.set_expr(v);
        xPathFragment.set_parentNode(document.getDocumentElement());
        return xPathFragment;
    }

    @Override
    public String marshal(XPathFragment v) throws Exception {
        return v.get_expr();
    }

}