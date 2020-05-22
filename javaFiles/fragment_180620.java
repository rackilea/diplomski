TreeMap<String, Integer> map2 = new TreeMap<>(
    new Comparator<String>() {

        @Override
        public int compare(String str1, String str2) {
            if(map1.get(str1).equals(map1.get(str2))) {
                return 0;
            }
            return map1.get(str1) - map1.get(str2) > 0 ? -1 : 1;
        }
    });