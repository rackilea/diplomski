int largest = numbers[0];
int counter = 1;

for(int i=1; i< numbers.length; i++)
{
        if(numbers[i] > largest) {
                largest = numbers[i];
                counter = 1;
        } elseif (numbers[i] == largest) {
                counter++;
        }
}