//create a new array before you use it
values=new String[data.sheet.getLastRowNum()+1][data.sheet.getRow(1).getLastCellNum()+1];
for(/*alltherows*/){

    for(/*all the columns */){
        //Now you're putting a value in one spot on the array
        values[row][col]=data.sheet.getRow(row).getCell(col).getStringCellValue();

    }
    //data access stuff... NO LONGER NULL :)!!
}