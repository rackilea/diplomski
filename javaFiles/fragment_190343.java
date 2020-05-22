SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");

        String[] anArray = new String[3];

        char c ='E';
        for (int i =0 ;i <anArray.length;i++) {

            try{
                anArray[i]= "001,"+ format.format(new Date()) +",,"+c+",";
                c++;
            //  show array element every 10sc with new date and time. 
                Thread.sleep(10000);
            }catch(InterruptedException ex){

            }

            System.out.println(anArray[i]);

        }