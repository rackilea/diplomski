String Sname=   name.getText();
  String Semail=  emailid.getText();
  String Smobile=   mobile.getText();
  String SmachineKey=  machineKey.getText();
  String SproductKey=  productkey.getText();
  String SserialNumber=  serialNo.getText();    

    JSONObject reqObj=prepareReqJsonObj(Sname,Semail,Smobile,SmachineKey,SproductKey,SserialNumber);

    String reqString= reqObj.toString();
    String APIUrl=  "http://example.com/v1/api";

   String response=  Utility.excutePost(APIUrl, reqString);

   System.out.println(reqObj);
   System.out.println(reqString);
   System.out.println(response);

 }

@SuppressWarnings("unchecked")
public JSONObject prepareReqJsonObj(String s1,String s2,String s3,String s4,String s5,String s6){
 JSONObject jsonobj = new JSONObject();



    jsonobj.put("name", s1);
    jsonobj.put("emailid", s2);
    jsonobj.put("mobile",s3 );
    jsonobj.put("machineKey",s4 );
    jsonobj.put("productkey", s5);
    jsonobj.put("serialNo", s6);

    return jsonobj;