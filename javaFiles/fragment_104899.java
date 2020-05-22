List<String> results = new ArrayList<String>();

for (Map<String, String> map : someList) {
    StringBuilder sb = new StringBuilder();
    for (String s : map.values()) {
        sb.append(s).append('-');
    }
    String result = sb.toString();
    results.add(result.substring(0, result.length() - 1); // To cut the trailing '-'
}
// Do whatever with the results.