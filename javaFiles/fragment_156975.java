String line = ...
String[] search = new String[]{...};

boolean match = true;

for(int i = 0 ; i < search.length && match ; i++)
    match = line.contains(search[i]);