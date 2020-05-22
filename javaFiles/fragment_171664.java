public static void main(String[] args) {
ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
ArrayList<Integer> out = new ArrayList<Integer>(); 
for(int i =1;i<=2;i++) {
    out.add(i);
    ArrayList<Integer> freeze = new ArrayList<Integer>(out);
    result.add(freeze);
}

System.out.println(result.toString());
}