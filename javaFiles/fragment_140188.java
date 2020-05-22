String line = "12 53 296 1";
String[] line= s.split(" ");
int[] numbers = new int[splitted.length];
boolean correct=true;
if(splitted.length <10)
{
    correct=false;
}
for(int i=0;i<splitted.length;i++)
{
    try
    {
        numbers[i] = Integer.parseInt(splitted[i]);
    }
    catch(NumberFormatException exception)
    {
        correct=false;
        System.out.println(splitted[i] + " is not a valid number!");
    }
}