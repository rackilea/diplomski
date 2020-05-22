System.out.print("Enter the number of lines:");
Scanner kb=new Scanner(System.in);
int number=Integer.parseInt(kb.nextLine());
String []line=new String[number];
//loop through only the size of the array
for(int i=0; i < line.length; i++){
    line[i]=kb.nextLine();
}
//now to output the array in reverse order you need to start from the
//other end of the array
for(int i = line.length - 1; i >= 0; i--){
    System.out.println(line[i]);
}
//always close the Scanner when done
kb.close();