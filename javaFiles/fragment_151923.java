public String checkDates(String startDate, String endDate) {
    try {

        ArrayList<String> Lines = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int count = 0;
        int check = 0;
        String[] lineArray = new String[8];
        String DateSelected = "";
        String testing="";
        File file = new File("TopUp.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) 
        {

            lineArray[count] = line+"\n";

            if (count < 8){
                count ++;
            }

            if (count == 8){
                if(check == 1){

                testing += lineArray[0];
                testing += lineArray[1];
                testing += lineArray[2];
                testing += lineArray[3];
                testing += lineArray[4];
                testing += lineArray[5];
                testing += lineArray[6];
                testing += lineArray[7];
                check = 0;
                }
            }
            if (count == 8){
                count = 0;
                check = 0;
                lineArray = new String[8];
            }


            if (line.contains("DATE")){
                try {
            DateSelected = line.replace("DATE: ", "");
            Date MainDate = sdf.parse(DateSelected);
            Date SDate = sdf.parse(startDate);
            Date EDate = sdf.parse(endDate);
            if(MainDate.compareTo(SDate)>=0 && MainDate.compareTo(EDate)<=0 ){ 

//is after Sdate and before eDate
                    check = 1;
                }
//              if(MainDate.compareTo(SDate)<0){ //is Before SDate
//                  
//              }
//              if(MainDate.compareTo(SDate)==0){ //is equal to mainDate
//                  
//

            }
            } catch (ParseException e) {
                //e.printStackTrace();
            }

            }
            stringBuffer.append(line);

            Lines.add(line + "\n");
            stringBuffer.append("\n");



        }
        fileReader.close();
        return testing;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}