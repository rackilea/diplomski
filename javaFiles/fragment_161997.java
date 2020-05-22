public static void main(String[] args) {
    String version[] = { "3.1.2", "2.1.7", "3.1222.1", "3.10.1", "3.10",
            "3.7.3", "2.6.4", "1.3.4.7" };
    Arrays.sort(version, new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            //Split tokens into arrays
            String[] tokens1 = o1.split("\\.");
            String[] tokens2 = o2.split("\\.");

            //Compare existing elements of each array
            for (int i = 0; i < tokens1.length && i < tokens2.length; i++) {
                int comparison = Integer.valueOf(tokens1[i]).compareTo(
                        Integer.valueOf(tokens2[i]));
                if (comparison != 0) {
                    return comparison;
                }
            }
            //Compare how specific each version is promote the most general
            //Only considered if version lengths != in size but equal in compared tokens
            return tokens1.length - tokens2.length;
        }

    });

    for (String v : version) {
        System.out.println(v);
    }
}