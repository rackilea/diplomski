public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] date=new String[5];
    // make comp a 2d Array
    String[][] comp = new String[5][];
    int mm, dd, yyyy;
    for(int ctr=0;ctr<date.length;ctr++){
        System.out.print("Enter Date: ");
        date[ctr]=input.nextLine();
        // At index ctr store the different parts of the date
        comp[ctr]=date[ctr].split("/");
        // This three steps can cause an ArrayOutOfRangeException, 
        // because the indexes 0,1,2 are depending on how many elements the split returned
        // You might want to add this here, but i´ll leave it out.
        // But since you never use mm, dd and yyyy you may aswell leave it out
        mm=Integer.parseInt(comp[ctr][0]);
        dd=Integer.parseInt(comp[ctr][1]);
        yyyy=Integer.parseInt(comp[ctr][2]);
    }
    for(int ctr1=0;ctr1<date.length;ctr1++){
        for(int j = 0;j<comp[ctr1].length;++j) {
            System.out.println(comp[ctr1][j] + " ");
        }
    }
}