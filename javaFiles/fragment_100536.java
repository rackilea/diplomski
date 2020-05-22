public static boolean compare(String h, char x){

       int counter = 0;
       boolean flag = false;

       for(int i = 0; i < h.length(); i++){
         counter++;
         if(h.charAt(i) == 'o'){
             flag = true;
         }
         else
             flag = false;
       }
        return flag;
}