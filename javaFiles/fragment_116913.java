public static void main(String[]args)
{
Scanner a=new Scanner(System.in);

//Arraylist stores all entered x values.
ArrayList<Integer> XValues=new ArrayList<Integer>();
//Arraylist stores all entered y values.
ArrayList<Integer> YValues=new ArrayList<Integer>();

for(int i=0;i<10;i++)
{
    int xval;
    int yval;

    System.out.println("Try no. #"+(i+1));
    System.out.print("Please enter x coordinate: ");
    xval=a.nextInt();
    System.out.print("Please enter y coordinate: ");
    yval=a.nextInt();

    if(i>0)
    {

        for(int d=0;d<YValues.size();d++)
        {
            if(xval==XValues.get(d) && yval==YValues.get(d))
            {
                System.out.println("Sorry.Already entered.\n");
                break;
            }
        }

    }

    XValues.add(xval);
    YValues.add(yval);
}