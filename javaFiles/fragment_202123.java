ArrayList<Integer> rand=new ArrayList<Integer>();
ArrayList<Integer> atoz=new ArrayList<Integer>();
    for(int a=0;a<26;a++) {
        atoz.add(a);
    }
for(int b=0;b<26;b++) {
    int temp=(int)(Math.random()*(26-b));
    rand.add(atoz.get(temp));
    atoz.remove(temp);
    }