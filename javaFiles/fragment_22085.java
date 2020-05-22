Pattern pat = Pattern.compile("([^&=]+)=([^&]*)");
    Matcher matcher = pat.matcher(requestUri);
    Map<String,String> map = new HashMap<>();
    while (matcher.find()) {
        map.put(matcher.group(1), matcher.group(2));
    }
    System.out.println(map);