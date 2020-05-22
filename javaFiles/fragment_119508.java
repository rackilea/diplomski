public static String AfterTimeIncrement(String Ptime,long Minutes){//Ptime should 12 houres like 12:10 
            String str1=Ptime;
            System.out.println("startTime========"+str1);
            String hours=str1.substring(0,str1.indexOf(':'));
            String minutes=str1.substring(str1.indexOf(':')+1);
            long hours1=Long.parseLong(hours);
            long minutes1=Long.parseLong(minutes);
            long minutes2=minutes1+Minutes;
            String endTime="";
            int i=(int) (minutes2%60);//60)n(j == i
            int j=(int) (minutes2/60);

            int houres2=(int)(hours1+j);

            int k=(int)(houres2%12);
            int l=(int)(houres2/12);

            if(houres2<=12){

            }else{
               houres2=k;
            }
            if(i<10){
               endTime=(houres2)+":0"+i;
            }else{
               endTime=(houres2)+":"+i;
            }

            System.out.println("endTime========"+endTime);
            return endTime;
        }