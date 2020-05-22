Scanner S=new Scanner(System.in);
int[] arr1=new int [6];
for (int i = 0; i < 6; ++i) {
    int g = S.nextInt();
    arr1[i] = g;
}

int input=6;

double total=0d;
double mean;

for(int i=0;i<input;i++)
{
    total=total+arr1[i];
}
mean= total/input;

System.out.println("the mean is:" + mean);