public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] name = {"Milk","Juice","Energy drink","Water","Softdrink","Beer","Wine","Coffee"};
        int[] pnum = {0,1,2,3,4,5,6,7};
        double[] price = {300,100,220,120,200,350,400,130};
        String[] list = {"Enter product #: ","Enter quantity: ","Sub-total: "};
        double sum=0,q=0,v,s;
        int sum2=0, w;
        String z = "";
        int x,c = 0;
        System.out.println("            Product Information");
        System.out.println("------------------------------------------");
        System.out.println("Name                        Price");
        System.out.println("------------------------------------------");
        System.out.println(pnum[0]+"."+name[0]+"                         "+price[0]);
        System.out.println(pnum[1]+"."+name[1]+"                        "+price[1]);
        System.out.println(pnum[2]+"."+name[2]+"                 "+price[2]);
        System.out.println(pnum[3]+"."+name[3]+"                        "+price[3]);
        System.out.println(pnum[4]+"."+name[4]+"                    "+price[4]);
        System.out.println(pnum[5]+"."+name[5]+"                         "+price[5]);
        System.out.println(pnum[6]+"."+name[6]+"                         "+price[6]);
        System.out.println(pnum[7]+"."+name[7]+"                       "+price[7]);
        System.out.println("------------------------------------------");
        do{
        System.out.print("Enter number of products: ");
        int a = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (x=0;x<a;x++) {

            System.out.print(list[0]);
            w = sc.nextInt();
            sum2 =w;
            System.out.print(list[1]);
            s = sc.nextDouble();
            q = s * price[w];
            System.out.println(list[2]+q);
            sb.append(pnum[sum2]+"."+name[sum2]+"---------"+q + "\n");
            sum +=q;

        }
        System.out.println("Total: " + sum);
        System.out.print("Do you want another transaction?(y/n):");
        z = sc.next();
        x = a;
        v = q;
        System.out.println("Transaction Details"); 
        System.out.println(sb);
         System.out.println("TOTAL: " + sum);
         System.out.print("Enter cash amount: ");
         double i = sc.nextDouble();
         if(sum>i){
             System.out.println("Cash is insuffecient! Please try again:");
             System.out.print("Enter cash amount: ");
             i = sc.nextDouble();
         }
         double tc = i - sum;
         System.out.print("Cash change"+tc);
        }
        while(z.equals("y")); 


    }