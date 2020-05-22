BufferedReader br = new BufferedReader(new FileReader("A.txt");
String data = br.readLine();
String a[] = data.split(",");
for(int i = 0;i<5;i++)
{
   System.out.println(a[i]);
}