final static Map<Character, String> ascii = new HashMap<>();
static {
    for (String[] pair : code){
        ascii.put(pair[0].charAt(0), pair[1].trim());
    }
}