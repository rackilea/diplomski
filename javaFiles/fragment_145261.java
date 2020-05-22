String[] chars = {"1","2","10"};
    //sort the array by length, so we check the longest string first.
    Arrays.sort(chars, (a,b)->b.length()-a.length());
    String foo = "1 2 3 4 5 6 7 8 9 10";
    String newFoo = "";
    for(int i = 0; i <= foo.length();){
        int j = i;
        for(String s : chars){
            if(foo.length() > i + s.length()){
                //find subString instead of character.
                String sub = foo.substring(i, i + s.length());
                if (sub.equals(s)) {
                    //move to the next index. Ex if 10 is at 0, next check start at 2
                    i += sub.length();
                    newFoo += sub;
                    break;
                }
            }
        }
        // check the index if it has been modified
        i = i == j ? ++j : i;
    }
    System.out.println(newFoo);