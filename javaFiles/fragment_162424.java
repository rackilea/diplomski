public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int n=sc.nextInt();
    sc.nextLine();
    String name;
   List<String> nameList= new ArrayList<>();
    for(int i=0;i<n;i++)
    {
        name=sc.nextLine();
        nameList.add(name);
    }
    System.out.println(nameList);
}