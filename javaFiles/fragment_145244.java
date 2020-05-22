public String toString(){
     String result = "";
     for (int scan =top-1 ; scan >= 0; scan--)
         result = result + stack[scan].toString() + "\n";
     return result;
 }