public class ClassCreator {

    public static void main(String[] args) throws Exception {
        // creates the compilation unit
        CompilationUnit cu = createCU();

        // prints the created compilation unit
        System.out.println(cu.toString());
    }

    /**
     * creates the compilation unit
     */
    private static CompilationUnit createCU() {
        CompilationUnit cu = new CompilationUnit();
        // set the package
        cu.setPackage(new PackageDeclaration(ASTHelper.createNameExpr("java.parser.test")));

        // create the type declaration 
        ClassOrInterfaceDeclaration type = new ClassOrInterfaceDeclaration(ModifierSet.PUBLIC, false, "GeneratedClass");
        ASTHelper.addTypeDeclaration(cu, type);

        // create a field
        FieldDeclaration field = new FieldDeclaration(ModifierSet.PUBLIC, new ClassOrInterface(String.class.getName()), new VariableDeclarator(new VariableDeclaratorId("variableName")))
        ASTHelper.addMember(type, field);
        return cu;
    }
}