//because this persistent Attribute is Long:
private Long projectNo; 

//we use Long here as well
ParameterExpression<Long> pexp = cb.parameter(Long.class, "projectNo");
...
//and finally set parameter. Long again, because that is the type 
// type of ParameterExpression:
query.setParameter("projectNo", Long.valueOf(projectNo));