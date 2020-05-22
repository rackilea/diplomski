public static void main(String [] args){
    String [] names = { "0.0.1.1",
                        "1.0.1.1",
                        "0.0.1.2",
                        "0.0.1.5",
                        "0.0.1.11",
                        "0.0.0.100",
                        "0.0.0.256",
                        "0.0.2.1",
                        "0.0.1.68"};
    String maxVersion = names[0];

    for(int i = 1; i < names.length; i++){
        if(compare(maxVersion, names[i]) == 1)
            maxVersion = names[i];
    }
    System.out.print(maxVersion);
}
static int compare(String a, String b){
     String[] sA = a.split("\\.");
     String[] sB = b.split("\\.");
     for(int i = 0; i < sA.length; i++){
        int cmp = Integer.compare(Integer.parseInt(sB[i]), Integer.parseInt(sA[i]));
        if(cmp != 0)
            return cmp;
     }
    return 0;
}