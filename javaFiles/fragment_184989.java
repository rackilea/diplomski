String input = "011000010110000101100001";
String output = "";
for(int i = 0; i <= input.length() - 8; i+=8)
{
    int k = Integer.parseInt(input.substring(i, i+8), 2);
    output += (char) k;
}