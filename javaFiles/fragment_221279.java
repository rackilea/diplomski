cst.setInt(1,userId);
cst.setLong(2,taskId);
cst.setString(3, date);

cst.registerOutParameter(1, Types.NUMERIC);
cst.registerOutParameter(2, Types.NUMERIC);
cst.registerOutParameter(3, Types.VARCHAR);

rs = cst.executeQuery();