Scanner scan1 = new Scanner("hello 1 2 3.5 there");
int index = 0;
while(scan1.hasNext()) {
    if(scan1.hasNextInt()) {
        index = index + 1;
        scan1.nextInt();
    } else {
        scan1.next();
    }
}

System.out.println("there are "+index+" integer tokens");

int[] numbers = new int[index];
int i = 0;

Scanner scan2 = new Scanner("hello 1 2 3.5 there");
while(scan2.hasNext()) {
    if(scan2.hasNextInt()) {
      numbers[i++] = scan2.nextInt();
    } else {
        scan2.next();
    }
}

for (int j = 0; j < numbers.length; j++) {
   System.out.println(numbers[j]);
}