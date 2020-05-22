import java.util.*;

public class CommandLineRunner {

    public static void main(String args[]){

        //Collect the input parameters...
        HashMap<String, String> argsMap = new HashMap<String, String>();
        for (int i = 0; i < args.length; i++){
            StringTokenizer st = new StringTokenizer(args[i], "=");
            while(st.hasMoreTokens()) {
                String key = st.nextToken();
                //Handle the case you don't define a key/value with '='
                try{
                    String val = st.nextToken();
                    argsMap.put(key, val);
                }catch(NoSuchElementException e){
                    argsMap.put(key, "");
                }
            } 
        }

        //Then use them when needed...
        for (Map.Entry<String,String> entry : argsMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("arg: "+ key + "\tval:" + value);

            if(key.equals("runType")){
                //Add your business logic here
            }
            else if (key.equals("threadCnt")){
                //Add your business logic here
            }
            else if (key.equals("cleanLogs")){
                //Add your business logic here
            }else
                //Unknown argument
                throw new RuntimeException("Invalid argument!");
        }
    }
}