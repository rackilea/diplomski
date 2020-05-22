public static void main(String[] args) throws Exception {
    List<List<String>> hm = new ArrayList();

    for(int j=0; j<3;j++){
        List<String> al = new ArrayList();
        for(int i=0; i<1;i++){
            if(j==0){al.add("a");}
            else if(j==1){al.add("a");al.add("b");}
            else if(j==2){al.add("a");al.add("b");al.add("c");}
        }
        hm.add(al);
    }
    System.out.println("hm final"+hm);
}