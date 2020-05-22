String sql = "update toplosers set Moving50 = ? where Symbol = ?";  
PreparedStatement stmt = conn.prepareStatement(sql); 
for(int i1=0;i1<i;i1++)
 {   

       stmt.setString(1, moving50[i1]); 
       stmt.setString(2,symbol[i1]);


    stmt.addBatch(); 
} 
stmt.executeBatch();  
}