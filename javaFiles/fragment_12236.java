public static void main(String args[]) throws IOException{

student s1=new student();
BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter the total number of subjects ");
try{
s1.n=Integer.parseInt(br.readLine());
}catch(NumberFormatException e)
{}
//int a=s1.n-1; // By doing this, you make the array one shorter than you seem to need, so you will not be able to enter the data for the last subject.
int a=s1.n; //this should have enough space to store marks for all subjects.
s1.m=new int[a];
int i=0;
System.out.println("Please enter your marks one after another ");
while(i<a)
{
    try{
    s1.m[i]=Integer.parseInt(br.readLine());
    }catch(NumberFormatException e)
    { System.out.println("Bad value entered, please enter again "); // additional check for invalid numbers, just in case ;) 
    continue;}
    i++;
}
s1.calculate();
}