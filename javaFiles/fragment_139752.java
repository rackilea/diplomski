PreparedStatement ps = con.prepareStatement("SELECT * FROM qc WHERE qid > ? ORDER BY qid LIMIT 1");
ps.setInt(1, currentQid);
ResultSet rs=ps.executeQuery();
if(rs.next()){
    currentQid = rs.getInt("qid");
    jTextField1.setText(Integer.toString(currentQid));
    jTextField2.setText(rs.getString("ques"));
}