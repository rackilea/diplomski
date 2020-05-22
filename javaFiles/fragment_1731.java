String str = "AxnZt_35\\/435\\/46\\/34";

    System.out.println(str); //prints AxnZt_35\/435\/46\/34

    String s2 = str.replaceAll("\\\\/", "/"); 

    System.out.println(s2); //prints AxnZt_35/435/46/34