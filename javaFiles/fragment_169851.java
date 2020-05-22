File input1 = new File("H:\\Desktop\\input1.txt");
Scanner scan = new Scanner(input1);

File input2 = new File("H:\\Desktop\\input2.txt");
int num;
List<Integer> list = new ArrayList<Integer>();

while(scan.hasNextInt())
{
    num = scan.nextInt();
    list.add(num); 
}
scan = new Scanner(input2); // Point Scanner to new file    
while(scan.hasNextInt()) // Loop through new file
{
    num = scan.nextInt();
    list.add(num); 
}
Collections.sort(list); // sort list after populating it from both files

// Printing to file
PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
for(int numberInList : list) { // Loop through sorted list and print out list to file
    writer.println(numberInList);
}
writer.close(); // Close the file