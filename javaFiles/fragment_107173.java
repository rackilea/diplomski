Scanner scanner = new Scanner(new File(file));
ArrayList<String> animalData = new ArrayList<String>();
while (scanner.hasNext()) {
    String[] columns = scanner.nextLine().split("/t");
    String data = columns[columns.length-1];
    animalData.add(data);
    System.out.println(data);
}

int size = animalData.size();
String[] arr1 = new String[size]; String[] arr2 = new String[size]; 
String[] arr3 = new String[size]; String[] arr4 = new String[size];
for(int i=0;i<size;i++)
{
    String[] temp = animalData.get(i).split("\t");
    arr1[i] = temp[0];
    arr2[i] = temp[1];
    arr3[i] = temp[2];
    arr4[i] = temp[3];
}