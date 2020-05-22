String strQuery = "insert into toto values (?,?)";

ParamDescriptor paramToPass1 = ParamDescriptor.forString("TheValueForTheString");
ParamDescriptor paramToPass2 = ParamDescriptor.forString("TheValueForTheString2");

List<ParamDescriptor> parameters = new ArrayList<ParamDescriptor>();
parameters.add(paramToPass1);
parameters.add(paramToPass2);

executeInsertStmt(strQuery, parameters);