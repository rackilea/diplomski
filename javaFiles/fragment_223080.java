import javax.xml.bind.annotation.XmlTransient;

import org.w3c.dom.Node;

class XPathFragment {
    String _expr;

    // we need this to look up namespace prefixes used in _expr
    Node _parentNode;

    public String get_expr() {
        return _expr;
    }

    public void set_expr(String _expr) {
        this._expr = _expr;
    }

    @XmlTransient
    public Node get_parentNode() {
        return _parentNode;
    }

    public void set_parentNode(Node _parentNode) {
        this._parentNode = _parentNode;
    }

}