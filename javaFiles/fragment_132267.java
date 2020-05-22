//.... other existing code
String pat = "\"(.*)\": \"(.*)\"";
Pattern pattern = Pattern.compile(pat);
Matcher matcher = null;
Map<String,String> map = new HashMap<String,String>();

while ((url = br.readLine()) != null) {
    if ((chk >= 0) && ((chk < end))) {  
        matcher = pattern.matcher(url);
        if(matcher.find()) {
            map.put(matcher.group(1), matcher.group(2));
        }
        //r.append(url).append('\n');
    }
} 
System.out.println(map.get("id"));
//... rest of code