String str="NH3PO4";

    int lastChar=str.lastIndexOf("O");//replace "O" into a param if needed
    String toParse=str.substring(lastChar+1);
    System.out.println("toParse="+toParse);
    try{
        System.out.println("after parse, " +Integer.parseInt(toParse));
    }
    catch (NumberFormatException ex){
        System.out.println(toParse +" can not be parsed to int");
    }
}