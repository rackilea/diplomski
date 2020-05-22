// somewhere to store the result
 static StringBuilder result = new StringBuilder();

 public static void main(String [] args) {

     // starting string
     String s = "1234567";
     // or as 
     //String s = Integer.toString(1234567);

     // call with full string
     recurse (s);

     // print result
     System.out.println("result : " + result.toString());
}

private static void recurse(String s) {

    // take first char and add to result
    String c = s.substring(0,1);
    result.append(c);

    // see if even, note no error checking for is a number
    if (Integer.parseInt(c) % 2 == 0) {
        result.append("0");
    }

    // then if still has content then strip off first char and call again
    if (s.length() > 1)
        recurse(s.substring(1));

}