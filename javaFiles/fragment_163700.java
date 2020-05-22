String[] source = { "java", "streams", "are", "great", "stuff"};
List<String> result = new ArrayList<>();
int limit = 3;
for(String s: source) {
    System.out.println("filtering " + s);
    if(s.length()>=4) {
        System.out.println("mapping " + s);
        String t = s.toUpperCase();
        if(limit-->0) {
            result.add(t);
        }
        else break;
    }
}