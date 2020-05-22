Scanner in = new Scanner(System.in);

   int N_small= 0, N_big = 0 ,i;

   System.out.printf("Enter the first number: ");
   N_small = in.nextInt();
   System.out.printf("Enter the second number: ");
   N_big = in.nextInt();

if (N_small < N_big) {
         System.out.printf("The numbers are:");           
       for (i = N_small; i < N_big+1 ; i=i+N_small){
         if(i > N_big) System.out.println(N_big); else System.out.println(i);  

    }   
   }
  }