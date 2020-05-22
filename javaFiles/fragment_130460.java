String str = "This is test"
+"\nb=4"
+"\n/* a=b+c; */"
+"\nb=5\nc=7"
+"\n/* a=b-c; */"
+"\na=b*c;";

for(String s : str.split("\\;(?!\\s*\\*\\/)")) {
    System.out.println(s);
}