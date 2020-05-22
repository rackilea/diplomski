Pattern mypattern = 
         Pattern.compile("Manufacturer\\s*#?:\\s*(.*?)\\s*(Price|Quantity)",
                                                       Pattern.CASE_INSENSITIVE);
Matcher mymatcher = mypattern.matcher("Manufacturer #: ABC company Price");
if (mymatcher.find()) {
    System.out.println(mymatcher.group(1)); // ABC company
}