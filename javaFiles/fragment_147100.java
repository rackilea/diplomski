String[] sarr = {"aaa\n==test==\naaa\nbbb\naaa", "bbb\naaa==toast==cccdd\nb\nc", 
                 "aaa\n==trick==\naaaDDDaaa\nbbb"};

Pattern pt = Pattern.compile("(?s)==(?!.*?==)([^(?:DDD)]*)");

for (String s : sarr) {
    Matcher m = pt.matcher(s);
    System.out.print("For input: [" + s + "] => ");
    if (m.find())
        System.out.println("Matched: [" + m.group(1) + ']');
    else
        System.out.println("Didn't Match");
}