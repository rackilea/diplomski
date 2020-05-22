public static void main(String[] args) {
        //Init
        ArrayList<ArrayList<Something>> mainList = new ArrayList<>();
        ArrayList<Something> sublist1 = new ArrayList<>();
        ArrayList<Something> sublist2 = new ArrayList<>();
        //Fill array lists
        sublist1.add(new Something("str1", 0));
        sublist1.add(new Something(5, 1));
        sublist1.add(new Something("str2", 0));
        sublist1.add(new Something("str3", 0));
        sublist1.add(new Something(3.5f, 2));
        //etc
        sublist2.add(new Something("str5", 0));
        sublist2.add(new Something(6, 1));
        sublist2.add(new Something("str6", 0));
        sublist2.add(new Something("str7", 0));
        sublist2.add(new Something(5.3f, 2));
        //etc
        //Add the two list in the main
        mainList.add(sublist1);
        mainList.add(sublist2);
        //Iterator
        int i = 0;
        for (ArrayList<Something> sublist : mainList) {
            i++;
            System.out.println("Results from list " + i);
            for (Something something : sublist) {
                switch (something.getType()) {
                    case 0: {
                        System.out.println("String value: " + (String) something.getValue());
                        break;
                    }
                    case 1: {
                        System.out.println("Integer value: " + (Integer) something.getValue());
                        break;
                    }
                    case 2: {
                        System.out.println("Float value: " + (Float) something.getValue());
                        break;
                    }


                }
            }
        }

    }