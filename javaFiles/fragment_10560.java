Properties prop = new Properties();

// add some properties
prop.put("user/a/b", "active");
prop.put("user/a/c", "active");
prop.put("user/a/d", "active");

// save the Property names in the set
Set<String> set = prop.stringPropertyNames();
for (String name: set) {
    if (name.startsWIth("user/a/")) {
        //check value and do something
    }
}