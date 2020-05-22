String regex="(?<key>\\S+)\\s+(?<operator>\\S+)\\s+(?<value>'[^']*'|\\S+)";
    for(String s:filter.split("\\s*and\\s*(?=([^']*'[^']*')*[^']*$)"))
    {
        Matcher m=Pattern.compile(regex).matcher(s);
        while(m.find())
        {
            System.out.println("Key:"+m.group("key"));
            System.out.println("operator:"+m.group("operator"));
            System.out.println("Value:"+m.group("value"));
        }
    }