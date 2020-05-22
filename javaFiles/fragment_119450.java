String str = "query at.mycollection ntoreturn:1 reslen:1833 nscanned:1  nquery: { like_symbol: \"SC!JNJ\" }  nreturned:1 bytes:1817etc...";

    int index = str.indexOf("nquery:");
    int index2 = str.indexOf("nreturned:1");

    // some validation 
    if(index != -1 && index2 != -1 && index < index2){
        String str2 = str.substring(index, index2);

        str2 = str2.trim();

        System.out.println(str2);
    }
    else{
        System.err.println("Something wrong here");
    }
}