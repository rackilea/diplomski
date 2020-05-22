for(/*alltherows*/){

    for(/*all the columns */){
        //THIS IS YOUR ERROR!! You're creating a new array, and storing it in values
        values=new String[data.sheet.getLastRowNum()+1][data.sheet.getRow(row).getLastCellNum()+1];
        //Now you're putting a value in one spot on the array
        values[row][col]=data.sheet.getRow(row).getCell(col).getStringCellValue();

    }
    //data access stuff
}