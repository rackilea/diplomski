public static void main(String[] args) throws IOException {
int list[] = new int[10];
int i, num = 0, num1 = 0;
int returnvalue = 0;
String input = " ";
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

for (i = 0; i < 10; i++) {
    list[i] = 0;
    }
for (i = 0; i < 10; i++) {
    System.out.print("Input value for list[" + i + "] = ");    
    input = in.readLine();
    num = Integer.parseInt(input);
    list[i] = num;
    }

for (i = 0; i < 10; i++) {
    System.out.println("list[" + i + "] = " + list[i]);
    }
System.out.print("Input value for checking in  list ");
input = in.readLine();
num1 = Integer.parseInt(input);

boolean flag = false;
int[] arr = new int[10];
int count= 0;
for (int b = 0; b < list.length; ++b) {
  if (num1 == list[b]) {              
      flag = true;
      arr[count]=b;
      count++;
      }
}
if(flag)
{
   System.out.println("The value "+num1+" is in List!");
   System.out.println("There are "+count+" of it in List");
   System.out.print("Located at: ");
   for(int j=0; j<count;j++)
   {
    System.out.print(" List["+arr[j]+"]");
   }
} 
else {
System.out.print(" Element Not found");
}