String name = "abcde-abc-db-tada_x12.12_999ZZZ_121121.333";
Pattern p = Pattern.compile(".*_([^_]+)_.*");
Matcher m = p.matcher(name);
if (m.matches()) {

    System.out.println(m.group(1));  // Should print 999ZZZ

} else {
     System.out.println("not found"); 
}