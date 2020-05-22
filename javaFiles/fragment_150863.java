while(rs.next()) { 
     ilCounter++;
     ObjVoBean voObj = new ObjVoBean();
     voObj.setLoc(rs.getString(1));
     voObj.setDept(rs.getString(2));
     voObj.setDeptDesc(rs.getString(3));
}