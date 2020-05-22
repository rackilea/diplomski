void separateMyString(){
    String str = "my+%name===is+jhon!#and&^I$stay===in^&$#@US";
 ArrayList<String> stringdata = new ArrayList<String>();
 StringBuffer sb = new StringBuffer();
 boolean isInSameString = true;
 boolean prevStringValue = Character.isLetter(str.charAt(0));
 for(int i=0; i<str.length(); i++){
     isInSameString = (Character.isLetter(str.charAt(i))== prevStringValue) ?true:false;
    if(i == (str.length() -1)){
        isInSameString = false;
    }
     prevStringValue = Character.isLetter(str.charAt(i));

         if(!isInSameString){
             if(i == (str.length() -1)){
                 sb.append(str.charAt(i));
                }
             stringdata.add(sb.toString());
         sb = new StringBuffer();
         }

         sb.append(str.charAt(i));

 }
 System.out.println("~~~"+stringdata);
}