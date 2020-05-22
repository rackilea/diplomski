List<String> result = new ArrayList<String>();

Pattern p = Pattern.compile("(?>[^,'\"]++|(['\"])(?>[^\"'\\\\]++|\\\\.|(?!\\1)[\"'])*\\1|(?<=,|^)\\s*(?=,|$))+", Pattern.DOTALL);
Matcher m = p.matcher(checkString);

while(m.find()) {
    result.add(m.group());
}