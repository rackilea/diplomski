public static void createTriangle(int size, String let){
        for(int i=size;i>0;i--){
            int fill = i;
            int space = size-i;
            while(space>0){
                System.out.print(" ");
                space--;
            }
            while(fill>0){
                System.out.print(let);
                fill--;
            }
            System.out.println();   
        }
    }