//Convert ArrayList into an Array
int[] newArray = new int[myArray.size()];

for(int i = 0; i < myArray.size(); i++) {

        newArray[i] = myArray.get(i);

}
System.out.println("There were " + myArray.size() + " prime numbers");
System.out.println("Index\tValue");

for(int counter = 0; counter<newArray.length; counter++){
    System.out.println(counter+1 + "\t" + newArray[counter]);
}