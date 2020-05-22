public static void hourglass(int size, char symbol){

    int subtract = (int)Math.floor(size / 2);

    for(int i = size - subtract; i >= 1; i--){

        for(int j=i;j<size - subtract;j++){
          System.out.print(' ');
        }

        for(int j=1;j<=i*2-1;j++){
            System.out.print(symbol);
        }

        System.out.println();
    }

    for(int i = 2; i <= size - subtract; i++)
    {

        for(int j=i;j<size - subtract;j++){
            System.out.print(' ');
        }

        for(int j=1;j<=i*2-1;j++){
            System.out.print(symbol);
        }

        System.out.println();
    } 

}