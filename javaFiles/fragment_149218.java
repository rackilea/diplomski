public static void main(String[]args){
String formula = "E10+E11+SUM(E10;E14:E17)*E18-IF(E19<1,E20, E21)";
String output="";


for(String c: formula.split("[^A-z0-9]+")){
    if(isCell(c)){
               output+=c+" ";
    }
}


}

private static boolean isCell(String current){
   boolean hasLetter = false;
   boolean hasNumber = false;

for(int i=0; i<current.length() && (!hasLetter || !hasNumber); i++){


    if(current.charAt(i)>=65 && current.charAt(i)<=90){


        hasLetter=true;
    }
    else if(current.charAt(i)>='0' && current.charAt(i)<='9'){

        hasNumber=true;
    }
}

return hasLetter && hasNumber;
}