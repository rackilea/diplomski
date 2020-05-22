List<Float> grossPensionList = new ArrayList<Float>();
float grossPension;
while(rs.next()) {
    //To retrieve the first column
    grossPension = rs.getFloat("GrossPension");             
    log.info("GrossPension is :" +grossPension);
    grossPensionList.add(grossPension/5);        
 }

for (float tax: grossPensionList){
    System.out.println(tax);
}