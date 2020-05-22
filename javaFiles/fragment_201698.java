private JMethod makeHeadersWrapper( String endPointName, List<BasicNameValuePair> headersList ) {

    JClass headerClass = codeModel.ref( headersList.getClass() ).narrow( BasicNameValuePair.class );
    JMethod wrapperMethod = definedClass.method( JMod.PUBLIC | JMod.STATIC, headerClass, ( "make" + endPointName + "Header") );

    JVar headersListVar = wrapperMethod.body().decl( wrapperMethod.type(), "headersList", JExpr._new(headerClass) );
    for(BasicNameValuePair nameValuePair : headersList) {
        wrapperMethod.body().add(headersListVar.invoke("add").arg(JExpr._new(nameValuePairClass).arg(nameValuePair.getName()).arg(nameValuePair.getValue())));
    }
    wrapperMethod.body()._return( headersListVar );

    return wrapperMethod;
}