String[] strArray = str.split(",");
for(String string : strArray) {
char [] charArray = string.toCharArray();
    for (Character c : charArray)
    {
        if (!tc.containsValue(c))
            {
                temp=temp + c.toString() + ", ";
                tc.put(c.hashCode(),c);
             }
    }
}