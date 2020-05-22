public static void add(int[]a1,int[]a2){       
    int atotal[] = new int[20];
    int capacity3 = Math.max(a1.length, a2.length);
    for (int i = 0; i < capacity3; i++) {
        int a3 = a1[i] + a2[i] + atotal[i];
        System.out.println(a3);
        if(a3>9) {
            atotal[i] = a3 % 10;
            atotal[i+1] = a3 / 10;
        } else {
            atotal[i]=a3;
        }
    } 
    for(int i=capacity3; i>=0; i--) {
        System.out.print(atotal[i] + " ");
    }
}