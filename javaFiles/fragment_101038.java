String a = "";

for(int j=0; j<data[i]; j++)
{
    a = a + "*";
}
System.out.printf("%" + width + "s  %s\n", label[i], a);