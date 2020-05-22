public String printTriangle (int count) {
    if( count <= 0 ) return "";

    String p = printTriangle(count - 1);
    p = p + "*";
    System.out.println(p);

    return p;
 }