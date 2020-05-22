for(int k=0;k<data.size();k++) {
    String [] substr2 = data.get(k).split("\t");
    int length = substr2.length
    if (length >= 5) {
        RC1.add(substr2[4]);
    } else {
        System.out.println("no object found");
    }
    ....     
}