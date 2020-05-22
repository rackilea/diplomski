for (int i = 1; i < rowCount+1; i++) {
        Row row = RDSheet.getRow(i);
        //Check if the first cell contain a value, if yes, That means it is the new testcase name
    if((row.getCell(0)+"").toString().length()==0){
        //Print testcase detail on console
        System.out.println((row.getCell(1)+"").toString()+"----"+ (row.getCell(2)+"").toString()+"----"+
        (row.getCell(3)+"").toString()+"----"+ (row.getCell(4)+"").toString());
        //Call perform function to perform operation on UI
        //your operations
     }
else{

//Print the new testcase name when it started
            System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
            }
}


`