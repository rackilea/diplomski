private static Identifier getLiteralEqualsString(String name, IAttributeHandle ia) throws TeamRepositoryException {
    IWorkItemClient workItemClient = (IWorkItemClient) teamrepository.getClientLibrary(IWorkItemClient.class);

    Identifier literalID = null;
    IEnumeration enumeration = workItemClient.resolveEnumeration(ia, null); // or IWorkitemCommon
    List literals = enumeration.getEnumerationLiterals();
    for (Iterator iterator = literals.iterator(); iterator.hasNext();) {
        ILiteral iLiteral = (ILiteral) iterator.next();
        if (iLiteral.getName().equals(name)) {
            literalID = iLiteral.getIdentifier2();
            break;
        }
    }
    return literalID;
}