double sum = 0; //use a double instead of a float
for (String str : strings)
{
    sum += Double.parseDouble(str); //same as: sum = sum + Double.parseDouble(str);
    //+= means: add the value from the right of the operator (+=) to the left
}
System.out.println(sum);