string str = "4-12-103-250-302";
String[] parts = string.split("-");

int[] intArray = new int[parts.length];

for(int i = 0; i < parts.length -1; i++)
{
    intArray[i] = Integer.parseInt(parts[i]);
}