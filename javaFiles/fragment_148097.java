@Rule(key = "Banned Keyword Rule")
public class BannedKeywordRule extends IssuableSubscriptionVisitor {
    // Define the word to ban
    private static final String BANNED_KEYWORD = "BLABLA";

    @Override
    public List<Tree.Kind> nodesToVisit() {
        //  visit only the variables
        return ImmutableList.of(Tree.Kind.VARIABLE);
    }

    @Override
    public void visitNode(Tree tree) {
        VariableTree variableTree = (VariableTree) tree;
        // check if parent is CLASS aka variable is instance
        if(variableTree.parent().is(Tree.Kind.CLASS) && variableTree.simpleName().name().contains(BANNED_KEYWORD)) {
            reportIssue(variableTree, "String " + BANNED_KEYWORD + " can not be used as a instance variable.");
        }
    }
}