public class Consecutive
{
/***************************************************************************/
Author :- ShihabSoft
/***************************************************************************/
public static void main(String[] someArgs)
{
int[] args=new int[someArgs.length];
    for(int i=0;i<someArgs.length;i++)
        args[i]=Integer.parseInt(someArgs[i]);
        int swit=checkArrConsecutive(args);
        if(swit==0 || swit==1)
        System.out.println("All "+args.length+" values appeared accordingly in the array");

switch(swit)
{
    case 0:
        System.out.println("Array is not well packed.");
    break;
    case 1:
        System.out.println("Array is well packed");
}
}
//As per your needs we need two functions
static int checkArrConsecutive(int[] args)
{
int curr=0,temp=0;
if(args!=null)
{
int numIndex=0;
    for(int i=0;i<args.length;i++)
    {
        curr=args[i];
        temp=0;
        if(checkNoccursNtime(args,curr)==0)
        {
            System.out.println("Sorry the number :- "+curr+" at index '"+i+"' repeats more or less than '"+curr+"' times");
            return 2;
        }

        for(int j=numIndex;j<args.length;j++)
        {
        if(temp==curr)
            break;
        if(args[j]!=curr)
        {
            return 0;
        }
        else
            temp++;

        }
        if(curr!=(args.length!=(i+1) ? args[i+1] : args[i]))
        numIndex=i+1;

    }
return 1;


}
return 0;
}
static int checkNoccursNtime(int[] args,int n)
{
if(args!=null)
{
int curr=0,temp=0;
    temp=0;
    curr=n;
    for(int j=0;j<args.length;j++)
    {
        if(args[j]==curr && temp != curr)
            temp++ ;
        else if(args[j]==curr)
            return 0;
    }
return temp==curr ? 1 : 0;
}
return 0;
}

}