public String filterRepeats(String s) {
        LinkedHashSet<String> set = new LinkedHashSet<String>(Arrays.asList(s.split("\\s")));

        String result = "";
        for (String elt : set) {
            result += elt + " ";

        }
        // trim last space
        result = res2.substring(0, result.length()-1);
        return result;

}