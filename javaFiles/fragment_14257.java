while((nextLine = inFile.readLine())!= null){

   title = nextLine;
   department = inFile.readLine();
   year = Integer.parseInt(inFile.readLine());
   newList.addCourse(new Course(title, department, year));  
}