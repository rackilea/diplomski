int nnames;
String names[];

System.out.print("How many names are you going to save: ");
Scanner in = new Scanner(System.in);
nnames = in.nextInt();

names = new String[nnames];
in.nextLine();
for (int i = 0; i < names.length; i++){
        System.out.print("Type a name: ");
        names[i] = in.nextLine();
}