int i = 0;
  File objFile = new File("C:\\DATA.txt");
  BufferedReader br = new BufferedReader(new FileReader(objFile));
  String st;
  String strMemId = "1675683811,2002199221,3893245956,9184020972";
  String[] memid =strMemId.split(",");
  int matchValue = 0;
  String fromFile = "";
  while ((st = br.readLine()) != null)
  {
      fromFile += st;

  }
  for(i = 0;i<memid.length;i++)
  {
      matchValue = 0;

      if (fromFile.contains(memid[i].toString())){
          matchValue++;   
      }
      System.out.println("Memberid is :"+memid[i]);


      if (matchValue != 0) {
           objReport.setValidationMessageInReport("PASS" , memid[i] + " text Value is Matched");      
      } else {
          //                  continue;
          objReport.setValidationMessageInReport("FAIL" , memid[i] + " text Value is not Matched");
      }
  }
  br.close();