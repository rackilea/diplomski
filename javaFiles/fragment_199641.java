HashMap<String,Integer> mapCodeToUnit = new HashMap<String,Integer>();
mapCodeToUnit.put("A25", 3);
mapCodeToUnit.put("A26", 3);
mapCodeToUnit.put("A27", 3);


arrList.add("A25"+"\t\tCS 212"+"\t\tData Structures\t\t\t\t"+ mapCodeToUnit.get("A25"));
arrList.add("A26"+"\t\tIT 312"+"\t\tData Base Management System 2\t\t"+ mapCodeToUnit.get("A26"));
arrList.add("A27"+"\t\tIT 312"+"\t\tData Base Management System 2\t\t"+ mapCodeToUnit.get("A27"));

System.out.println("\n\t\tCodes to enroll");
String codeNo[] = new String[3];
for(int i = 0; i < 3; i++,num++)
{   
    codeNo[i] = scan.next();
}

int totalNumberOfUnit = 0;
for(int i =0; i < codeNo.length; i++) {
   totalNumberOfUnit += mapCodeToUnit.get(codeNo[i]);
}

tuitionFee = ( tuitionFee * totalNumberOfUnit  + miscFee )  / 3;