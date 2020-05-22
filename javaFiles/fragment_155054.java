String HEADER = "column1,column2,column3";
String COLUMN1 = HEADER.substring(0,HEADER.indexOf(",")+1); //Or just set it to "column1", but that would be violating the DRY principle!

//...Get line1, column1 from the file you are reading

if(!line1Column1.equals(COLUMN1))
{
    out.write(HEADER); 
}

// Print rows of data...