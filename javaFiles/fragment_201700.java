private JMethod makeHeadersWrapper( String endPointName, List<BasicNameValuePair> headersList ) {
    JMethod wrapperMethod = definedClass.method( JMod.PUBLIC | JMod.STATIC, codeModel.ref( headersList.getClass() ).narrow( BasicNameValuePair.class ), ( "make" + endPointName + "Header") );

    JVar headersListVar = wrapperMethod.body().decl( wrapperMethod.type(), "headersList", JExpr.direct(generateListConstructor(headersList)) );
    wrapperMethod.body()._return( headersListVar );

    return wrapperMethod;

}

private String generateListConstructor(List<BasicNameValuePair> headersList) {
    StringBuilder listEpr = new StringBuilder("new ArrayList<scope.BasicNameValuePair>(){{");
    for(BasicNameValuePair nameValuePair : headersList) {
        listEpr.append("add(new BasicNameValuePair(\"").append(nameValuePair.getName()).append("\", \"").append(nameValuePair.getValue()).append("\")); ");
    }
    return listEpr.append("}}").toString();
}