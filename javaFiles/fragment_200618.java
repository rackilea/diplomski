String csvLine = "Firstname;Lastname;Adress;product1;product2;product3;product4";

    //Index of "fromIndex" param is inclusive, that's why we need to add 1
    int pos = csvLine.indexOf(';', csvLine.indexOf(';', csvLine.indexOf(';') + 1) + 1);

    //Retrieve string from the char after the third semi-colon
    String truncatedLine = csvLine.substring(pos + 1);

    //Replace ";" by "::" on our substring
    truncatedLine = truncatedLine.replaceAll(";", "::");

    //Then concat the first part of csvLine with the second
    String result = csvLine.substring(0, pos + 1).concat(truncatedLine); 

    System.out.println(result);  //Print => Firstname;Lastname;Adress;product1::product2::product3::product4