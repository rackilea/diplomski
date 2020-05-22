public static void main(String[] args) {
    System.out.print("  |"); 
    for (int a = 1; a < 10; a++){
        int ans = a;
        if (ans < 10) {
            System.out.print("  "+ ans + "  ");
        } else {
            System.out.print(" " + ans + "  ");
        } 

    }System.out.println();
    for (int u = 1; u < 47; u++){
        System.out.print("-");
    } 
    System.out.println();
    for (int i = 9; i > 0; i --) { 
        System.out.print(i + " |");
            for (int c = 1; c < 10; c++) {
                int ans2 = i * c;
                if(c <= 10-i){ //Tweaked the logic here
                if (ans2 < 10) {
                System.out.print("  "+ ans2 + "  ");
                } else {
                    System.out.print(" " + ans2 + "  ");
                }
                }else {
                    System.out.print(" * ");
                }
            }
        System.out.println();
    }   
}