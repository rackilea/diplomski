String arg = "2.1k";
if (arg.endsWith("k")) {
    int val = (int) (Double.parseDouble(arg.substring(0, arg.length() - 1))
           * 1000);
    arg = String.valueOf(val);
}
System.out.println(arg);