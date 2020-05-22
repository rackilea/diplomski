int index = input.indexOf("is");
int count = 0;
while (index != -1) {
    count++;
    input = input.substring(index + 1);
    index = input.indexOf("is");
}
System.out.println("No of *is* in the input is : " + count);