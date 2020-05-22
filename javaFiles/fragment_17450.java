Scanner input = new Scanner (System.in);
String l;
l = input.nextLine();
char pre [] = l.toCharArray();

String out = "";

for (int i = 0;i<l.length();i++){
    if (pre[i]== '1')
    {
        out = out + "1";
    }               
    if (pre[i] == '2'||Character.toUpperCase(pre[i])== 'A'|| Character.toUpperCase(pre[i]) == 'B')
    {
        out = out + "2";
    }
}
System.out.println(out);