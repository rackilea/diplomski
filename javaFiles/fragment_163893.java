List<String> l1 = new ArrayList<String>();
        List<String> l2 = new ArrayList<String>();

        l1.add("A");
        l1.add("B");
        l1.add("C");

        l2.add("C");
        l2.add("D");
        l2.add("E");

        Set<String> s = new HashSet<String>();
        s.addAll(l1);
        s.addAll(l2);

        List<String> finalList = new ArrayList<String>();
        finalList.addAll(s);

        for (String str : finalList) {
            System.out.println(str);
        }