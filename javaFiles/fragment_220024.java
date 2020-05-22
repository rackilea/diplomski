String spCallRequest = "BEGIN  apps.xx01_cpc_ap_pkg.xx01_create_invoice(?, ?, ?,? ); END ; ";
stmt = oraAppUtils.connection.prepareCall(spCallRequest);
stmt.setString(1,paymentRequest.healthFacilityCode);
stmt.setString(2,paymentRequest.batchId);
stmt.setDouble(3,Double.parseDouble(paymentRequest.tariffAmount));
stmt.registerOutParameter(4, java.sql.Types.INTEGER);
stmt.execute();
System.out.println ("invoice id ="+stmt.getInt(4));