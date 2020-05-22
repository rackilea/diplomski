DbUtil db = null;
java.sql.CallableStatement cstmt = null;


db = new DbUtil();
cstmt = db.prepareCall("{ call jack.PACK_EMPLOYEE.get_namelist(?, ?, ?, ?, ?, ?, ?) }");

cstmt.registerOutParameter(1,OracleTypes.VARCHAR);
cstmt.registerOutParameter(2,OracleTypes.VARCHAR);
cstmt.setString(3,this.getIdNo());
cstmt.setString(4,pagenum);
cstmt.setString(5,pagesize);
cstmt.registerOutParameter(6,OracleTypes.VARCHAR);
cstmt.registerOutParameter(7,OracleTypes.VARCHAR);
stmt.execute();

this.setName(cstmt.getString(4));
this.setAddress(cstmt.getString(5));