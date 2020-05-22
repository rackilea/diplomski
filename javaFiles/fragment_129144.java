String test = "Well, {hero}Superman X. 123 Sr.{/hero}, the most lovable guy"+
                  " was hated by {lover}Louis{/lover}.";
Pattern p = Pattern.compile("(\\{\\w+\\})([\\w\\.\\s]+)(\\{/\\w+\\})");
Matcher m = p.matcher(test);
while(m.find()){
    System.out.println(m.group(2));
}