String callableQuery = "{call sp_calculate(?, ?, ?, ?)}";

cst.setInt(1, 1); // IN parameter
cst.setInt(2, 4); // IN parameter

cst.registerOutParameter(3, java.sql.Types.INTEGER); // OUT parameter
cst.registerOutParameter(4, java.sql.Types.INTEGER); // OUT parameter