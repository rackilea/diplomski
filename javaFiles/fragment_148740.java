StringBuilder check = new StringBuilder();
for(int i = 0; i < imageInByte.length; i++)
{
    check.append(Integer.toBinaryString(imageInByte[i]));
}

String array[] = check.toString().split("");

for(int i = 0; i < array.length; i++){
    System.out.println(array[i)];
}