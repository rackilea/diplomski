long endPointID = 99999999;
String strEndPointID = moduleResults.getString("id_amr_module").trim();
if(strEndPointID.matches("^\\d+$")){
    endPointID = Long.parseLong(strEndPointID);
}
msiRF.setEndpointID(endPointID);