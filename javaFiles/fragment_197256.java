HashMap<String,String> map = HashMap<String,String>();
map.put("Q","R");
...

String input  = "KU7";
String result = "";

for(char c : input.toCharArray())
    result += map.get(c+"");