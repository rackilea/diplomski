Scanner sc = new Scanner(new File ("test01.dat")); 
for (int r = 0; r < 6; r++){
    for (int c = 0; c < 3; c++){
        int temp = 0;
        temp = Integer.parseInt(sc.nextLine().trim());
        tri[r][c] = temp;
        System.out.print(tri[r][c]+" ");
    }
    System.out.println();
}