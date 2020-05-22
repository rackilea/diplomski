com.hp.hpl.jena.query.Query query = QueryFactory.create(queryStr);
QueryExecution qe = QueryExecutionFactory.create(query,model);
com.hp.hpl.jena.query.ResultSet rs = qe.execSelect();

while(rs.hasNext()){

 QuerySolution binding = rs.nextSolution();                     
 System.out.println(binding.get("ind")); 
}