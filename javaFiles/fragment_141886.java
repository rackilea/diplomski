boolean nameFound = false;
for (int i = 0; i<array.length;i++) {
    if((array[i].getName()).equals(name)) {
        System.out.println(name+ " is found at position " +i+"\n");
        nameFound = true;
        break;
    }
}

if(!nameFound) System.out.print("\nName not in list\n");