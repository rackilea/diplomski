ByteArrayOutputStream baos = new ByteArrayOutputStream();
...
int queryType = q.getQueryType();
switch (queryType) {
case Query.QueryTypeAsk:
    boolean b = qe.execAsk();
    ResultSetFormatter.outputAsRDF(baos, notation, b);
    retval = baos.toString();
    break;
case Query.QueryTypeConstruct:
    model = qe.execConstruct();
    model.write(baos, notation);
    retval = baos.toString();
    break;
case Query.QueryTypeDescribe:
    model = qe.execDescribe();
    model.write(baos, notation);
    retval = baos.toString();
    break;
case Query.QueryTypeSelect:
    ResultSet results = qe.execSelect();
    ResultSetFormatter.out(baos, results);
    retval = baos.toString();
    break;
}