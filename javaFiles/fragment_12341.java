Pattern pattern = Pattern.compile(".+(?<!form)\\.xsd");
for (String file : files) {                                 
    Matcher matcher = pattern.matcher(file);
    if(matcher.matches())                                                      
    {                                                                       
        System.out.println("Found >>>> "+file);
    }
}