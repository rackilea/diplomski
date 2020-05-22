String binary=toBin(head[11])+toBin(head[10])+toBin(head[9])+toBin(head[8]);
long unixSeconds=stringToInt(binary);

Date date = new Date(unixSeconds*1000L); 

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

sdf.setTimeZone(TimeZone.getDefault()); 

String formattedDate = sdf.format(date);
System.out.println(formattedDate); 


public static String toBin(byte numDec){

        int num= UnsignedBytes.toInt(numDec);
        if(num==0)
                return "00000000";

        String result=Integer.toBinaryString(num);
        int cont= 8-result.length()%8;
        if(cont!=8){
            for(int i=0; i<cont;i++){
                result="0"+result;
            }
        }
            return result;  }

public static long stringToInt(String bin){

          long result=0;
          bin= bin.trim();
          for(int i=bin.length()-1;i>=0;i--){
              String aux= String.valueOf(bin.charAt(i));          
              result+= Integer.parseInt(aux)* Math.pow(2, (bin.length()-1-i));
          }
          return result;
    }