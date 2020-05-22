String[] input = line.split(",");

String variable = input[0];

int[] grades= new int[input.lenght - 2];

for(int i = 1; i < input.length; i++)
{
    grades[i] = input[i];// you might have to do Integer.pareseInt(input[i]);
}