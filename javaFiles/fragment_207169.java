Collections.sort(hasil, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            // null check needed?
            int diff = getIntValue(o2) - getIntValue(o1);
            if (diff == 0) return o1.compareTo(o2);
            return diff;
        }

        int getIntValue(String str) {
            if (str == null) return 0;
            int value = 0;
            int indx = 0;
            while (indx < str.length() && Character.isDigit(str.charAt(indx))) {
                value = value * 10 + (str.charAt(indx) - '0');
                indx++;
            }
            return value;
        }
    });



    System.out.println(hasil);