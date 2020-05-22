BufferedReader in = new BufferedReader(new FileReader("transaction-list.txt"));
    System.out.println();
    System.out.println("SIX MOST RECENT TRANSACTIONS:");
    System.out.println();
    String[] last6 = new String[6];
    int count=0;
    while(in.ready()){
        last6[count++%6]=in.readLine();
    }
    for (int i=0; i<6;i++){
        System.out.println(last6[(i+count)%6]);
    }
    in.close();