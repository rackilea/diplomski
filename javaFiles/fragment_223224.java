private static final String TEST_ANNOTATION_PATH = "org.testng.annotations.Test";
private static final String TEST_INFO_ANNOTATION_PATH = "toolkit.utils.TestInfo";
private static final String REPORT_EMPTY_TEST_CASE_ID = "Method annotated with @TestInfo should have not empty testCaseId parameter";
private static final String REPORT_MISSING_TEST_INFO = "Method annotated with @Test should also be annotated with @TestInfo";
private static final String TEST_CASE_ID_SPLIT_PLACE = "testCaseId=";

private int methodStartLine = 0;
private int methodEndLine = 0;
private int annotationLine;
private String annotationLineText;

@Override
public List<Tree.Kind> nodesToVisit() {
    return ImmutableList.of(Tree.Kind.METHOD, Tree.Kind.ANNOTATION);
}

@Override
public void visitNode(Tree tree) {
    if (tree.is(Tree.Kind.METHOD)) {

        MethodTree methodTree = (MethodTree) tree;
        scanMethodTree(methodTree);

    } else if (tree.is(Tree.Kind.ANNOTATION)) {

        AnnotationTree annotationTree = (AnnotationTree) tree;
        scanAnnotationTree(annotationTree);

    }

}

private void scanMethodTree(MethodTree methodTree) {
    if (methodTree.symbol().metadata().isAnnotatedWith(TEST_ANNOTATION_PATH)) {
        if (methodTree.symbol().metadata().isAnnotatedWith(TEST_INFO_ANNOTATION_PATH)) {

            methodStartLine = methodTree.firstToken().line();
            methodEndLine = methodTree.lastToken().line();

        } else {
            reportIssue(methodTree.simpleName(), REPORT_MISSING_TEST_INFO);
        }
    }
}

private void scanAnnotationTree(AnnotationTree annotationTree) {
    if (annotationTree.symbolType().fullyQualifiedName().equals(TEST_INFO_ANNOTATION_PATH)) {

        annotationLine = annotationTree.firstToken().line();
        if (annotationLine >= methodStartLine && annotationLine < methodEndLine) {

            annotationLineText = context.getFileLines().get(annotationLine - 1).replaceAll("\\s", "");

            if (annotationLineText.contains("testCaseId")) {
                // {"ABC-123","DEF-456"} OR {("ABC-123"), ("DEF-456")}
                if ((annotationLineText.contains("{(\"") || annotationLineText.contains("{\""))
                        && (annotationLineText.contains("\")}") || annotationLineText.contains("\"}"))) {
                    reportCase1();
                }
                // ("ABC-123")
                else if (annotationLineText.contains("(\"") && annotationLineText.contains("\")")) {
                    reportCase2();
                }
                // "ABC-123"
                else if (annotationLineText.contains("\"") && annotationLineText.contains("\",")) {
                    reportCase3();
                }

            } else {
                addIssue(annotationLine, REPORT_EMPTY_TEST_CASE_ID);
            }
        }
    }
}

/**
 * Method report an issue if testCaseId = {"ABC-123","DEF-456",...,"AEF-159"} or
 * testCaseId = {("ABC-123"),("DEF-456"),...,("AEF-159")} has no values between
 * quotes.
 */
private void reportCase1() {
    String testCaseId = annotationLineText.split(TEST_CASE_ID_SPLIT_PLACE)[1].split("}")[0];
    testCaseId = testCaseId.replaceAll("\"", "").replaceAll("\\{", "").replaceAll(",", "").replaceAll("\\(", "")
            .replaceAll("\\)", "");

    if (testCaseId.length() == 0) {
        addIssue(annotationLine, REPORT_EMPTY_TEST_CASE_ID);
    }
}

/**
 * Method report an issue if testCaseId = ("ABC-123") has no value between
 * quotes.
 */
private void reportCase2() {
    String testCaseId = annotationLineText.split(TEST_CASE_ID_SPLIT_PLACE)[1].split("\"\\)")[0];
    testCaseId = testCaseId.replaceAll("\"", "").replaceAll("\\(", "").replaceAll(",", "");

    if (testCaseId.length() == 0) {
        addIssue(annotationLine, REPORT_EMPTY_TEST_CASE_ID);
    }
}

/**
 * Method report an issue if testCaseId = "ABC-123" has no value between quotes.
 */
private void reportCase3() {
    String testCaseId = annotationLineText.split(TEST_CASE_ID_SPLIT_PLACE)[1].split("\",")[0];
    testCaseId = testCaseId.replaceAll("\"", "").replaceAll(",", "");

    if (testCaseId.length() == 0) {
        addIssue(annotationLine, REPORT_EMPTY_TEST_CASE_ID);
    }
}