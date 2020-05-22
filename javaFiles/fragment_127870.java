Scanner in = new Scanner(System.in);

int N = in.nextInt();
int min = Integer.MAX_VALUE;
int secondMin = Integer.MAX_VALUE;

for(int i = 0; i < N; i++){
    int a = in.nextInt();

    if(a < min){
        secondMin = min; // the current minimum must be the second smallest
        min = a; // allocates the new minimum
    }

    else if (a < secondMin) {
        secondMin = a; // if we did not get a new minimum, it may still be the second smallest number
    }
}

System.out.println(min);
System.out.println(secondMin);