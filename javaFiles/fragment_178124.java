`
        List<String> aList = new ArrayList<String>();
        aList.add("4:78:34");
        aList.add("5:8:34");
        aList.add("8:18:90");
        aList.add("2:8:40");
        List<String> subList = new ArrayList<String>();
        for (int i = 0; i < aList.size(); i++)
        {

            String str = aList.get(i).substring(0, aList.get(i).length() - 3);
            subList.add(str);

        }
        System.out.println(subList);`