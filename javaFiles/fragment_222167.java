for (String str : stringList) {
    if (str.startsWith("abc/xyz")) {//here even you could use contains if you want to find for your pattern anywhere within string.
       System.out.println("I found the string");
       break;
    }
}