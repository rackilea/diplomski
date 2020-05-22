for (int NameIndex =0; NameIndex<NameTotalNumber; NameIndex++)
    {
        Name nameList = wb.getNameAt(NameIndex);
        System.out.println( "AliasName: "+nameList.getNameName());  

    }