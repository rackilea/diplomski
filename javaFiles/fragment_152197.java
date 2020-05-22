System.out.print("The last names that start with " + letter + " are ");
for (i = 0; i < numberOfStudents; i++) {
   if (students[i].startsWith(letter)) {
      System.out.print(students[i] + ", ");
   }
}
System.out.println();