public static List<Node> nodes = new ArrayList<Node>();
public static String[] Interest = new String[] {"I1","I2","I3","I4","I5","I6"};

public static void main(String[] args){
    System.out.println("Enter number of nodes");
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    for(int i=0;i<=n;i++) {
        Node node = new Node(i);
        node.setPreference("I1", 10);
        node.setPreference("I2", 8);
        //....
        node.setPreference("I6", 2);
        nodes.add(node);
    }

    System.out.println(nodes);
}