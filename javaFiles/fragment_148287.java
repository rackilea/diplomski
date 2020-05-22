Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                String left = o1[1]!=null ? o1[1] : "";
                String right = o2[1]!=null ? o2[1] : "";
                return left.compareTo(right);
            }
        });