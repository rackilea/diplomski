PreparedStatement stmt;
if(cache.contains(query)){
    stmt= cache.get(query)
}else{
     stmt=new PreparedStatement("SELECT * FROM `"+query.replace("`","\\`")+"`");
    cache.put(query,stmt);
}
return stmt.executeQuery();