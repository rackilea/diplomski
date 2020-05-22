int[] a = {1,2,3,4,5,6};

String str = "";

for(int i=0;i<a.length;i++)
{
    str = str + Integer.toString(a[i]);
}
System.out.println(str);