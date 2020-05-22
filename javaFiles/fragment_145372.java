Optional<BlockStmt> block = method.getBody();
NodeList<Statement> statements = block.get().getStatements();

for (Statement tmp : statements) {
    tmp.removeComment();
    System.out.println(tmp.toString());
}