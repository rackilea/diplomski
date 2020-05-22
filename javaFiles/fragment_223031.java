Void visitMemberSelect(MemberSelectTree memberSelect, Void p) {
    // Print the object
    memberSelect.getExpression().accept(this, p);
    System.out.print(".");
    // Print the name of the member
    System.out.print(memberSelect.getIdentifier());
}