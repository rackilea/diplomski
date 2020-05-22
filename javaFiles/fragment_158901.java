String str = "eef geggughhht oaiu hjekloykj";
final Pattern p = Pattern.compile("[aeiou]+", Pattern.CASE_INSENSITIVE); 

String[] arr = str.split("\\s+");
for (int i=0; i<arr.length; i++) {
    String cstr = p.matcher(arr[i]).replaceAll("");
    if ( cstr.length() >= (arr[i].length() - cstr.length()) ) {
        System.out.println(arr[i]);
    }
}