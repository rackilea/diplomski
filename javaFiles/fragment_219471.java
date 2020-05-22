public class HelloWorld{

     public static void main(String []args){
        String key = "1;2;3;4";
        String value = "Value1;Value2;Value whitespace;";

        String[] keyArr = key.split(";");
        String[] valueArr = value.split(";");

        String finalJSON = "{";
        for(int i=0; i<(keyArr.length > valueArr.length ? keyArr.length : valueArr.length); i++) {

            try {
                finalJSON += "\"" + keyArr[i] + "\"";
            }
            catch(ArrayIndexOutOfBoundsException e) {
                finalJSON += "\"null\"";
            }

            finalJSON += " : ";

            try {
                finalJSON += "\"" + valueArr[i] + "\"";
            }
            catch(ArrayIndexOutOfBoundsException e) {
                finalJSON += "\"null\"";
            }
            if(i!=(keyArr.length > valueArr.length ? keyArr.length : valueArr.length) - 1) 
                finalJSON += ", ";
        }
        finalJSON += "}";

        System.out.println(finalJSON);
     }
}