public class CategoryRule extends AbstractJavaRule {
public Object visit(ASTMemberValuePairs node, Object data) {

    boolean hasCategory = false;
    boolean hasParentCategory = false;

    for ( int i = 0; i < node.jjtGetNumChildren(); ++i ) {
        if ( node.jjtGetChild(i).getImage().equals("category") ) {
            hasCategory = true;
        } else if ( node.jjtGetChild(i).getImage().equals("parentCategory") ) {
            hasParentCategory = true;
        }
    }

    if ( hasCategory && !hasParentCategory ) {
        addViolation(data, node);
    }

    return data;
}