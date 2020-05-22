public class MethodPrintScanner extends TreePathScanner {

    @Override
    public Object visitMethod(MethodTree methodTree, Object o) {
        System.out.println(methodTree);
        return null;
    }
}