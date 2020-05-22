int nnames;
String names[];

System.out.print("How many names are you going to save: ");
Scanner in = new Scanner(System.in);
nnames = Integer.parseInt(in.nextLine().trim());

names = new String[nnames];
for (int i = 0; i < names.length; i++){
        System.out.print("Type a name: ");
        names[i] = in.nextLine();
}