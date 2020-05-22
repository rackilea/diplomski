ArrayList<Integer> element = new ArrayList<Integer>();

// Remove the for loop from here

while (scanner.hasNextInt()) {  // Use scanner.hasNextInt()
    element.add(scanner.nextInt());
}

for (int item : element) {  // Moved this for loop outside the while loop
    sum += item;
}

System.out.println(sum);