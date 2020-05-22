public static void main(String[] args) {
    String s = "first";

    s+=" second" ;
    if(args.length >0)
    s+=" third";

    System.out.println("s, = " + s);
}