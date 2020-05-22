public static void main(String[] args) 
{
Scanner input = new Scanner(System.in);




double y=-1;

double sum = 0;

double average = 0;

double dev = 0;

double var = 0;

double sqrx = 0;

int n = 0;


    System.out.println("Enter an integer:");
    y = input.nextInt();
    double z=y;
    int i=0;
    double x[] = new double[(int)z];
    while(y-->0){

   x[i] = input.nextDouble();

    sum += x[i];
   i++;         
    n++;
    average = sum / n;      


    }
    i=0;
    while(z-->0){
        sqrx += Math.pow(x[i]-average,2);
        i++;
    }
 var = sqrx / (n-1);
    dev = Math.sqrt(var);

System.out.println("Average: " + average);
System.out.println("Deviation: " + dev);
  }