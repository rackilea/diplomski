public static String replaceString(Map<String,String> map,String input) { 
    String[] arr = input.split("\\s");
    for (int i = 0;i<arr.length;i++) { 
        String val = map.get(arr[i]);
        if (val != null) arr[i] = val;
    }
    StringBuilder sb = new StringBuilder();
    for (String s : arr) {
        if (s == null || s.length() == 0 ) continue;
        sb.append(s).append(' ');
    }
    return sb.toString().trim();
}