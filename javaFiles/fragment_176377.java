String ary[]={"man","john","su"};
    String ary1[]={"john","man","su"};
    boolean isEqual = true;
    if(ary.length != ary1.length) {
        System.out.println("not equal");
    } else {
        int countEquals = 0;
        ArrayList<String> wordList = new ArrayList(Arrays.asList(ary1) );
        for (String str : ary) {
            if (wordList.contains(str)) {
                countEquals++;
                wordList.remove(str);
            } else {
                isEqual = false;
                System.out.println("not equal");
                break;
            }
        }
        if (isEqual) {
            System.out.println("equal");
        }
    }