String stringFromProc = "SONY,20,30,40;LG,1,4,8";
String[] array1 =  stringFromProc.split(";"); // simply use ;
// array1[0] = SONY,20,30,40
// array1[1] = LG,1,4,8

JSONObject jsonSubObject = null;
JSONObject jsonFinal = new JSONObject();
JSONArray jsonArrayRET = new JSONArray();

for(int i=0;i<array1.length;i++){
     String []array2 = array1[i].split(","); // simply use ,
     // create jsonobjects 
     // when i=0 mean for sony and next time i = 1 mean for LG  
     jsonSubObject = new JSONObject();
     jsonSubObject.put("prodName", array2[0]);
     jsonSubObject.put("mtd", array2[1]);
     jsonSubObject.put("lmtd", array2[2]);
     jsonSubObject.put("lm", array2[3]);
     // put every object in array 
     jsonArrayRET.add(jsonSubObject);
   }
     // finally put array in reported jsonobject
     jsonFinal.put("reported", jsonArrayRET);