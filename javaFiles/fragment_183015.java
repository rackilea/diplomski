long total = 0;
int count = 0;

while ((int newValue = getValue()) > -1) // or other escape condition
{
   total += newValue;
   long average = total / ++count;
   System.out.println(average);
}