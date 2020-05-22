Names newName1=new Names();
newName1.firstName = scan.nextLine();
newName1.lastName = scan.nextLine();
studentNames.add(newName1);

Names newName2=new Names();                //create new object for new name
newName2.firstName = scan.nextLine();
newName2.lastName = scan.nextLine();
studentNames.add(newName2);
Names item = studentNames.get(0);
System.out.print(item.firstName + " " + item.lastName);
Names item1 = studentNames.get(1);
System.out.print(item1.firstName + " " + item1.lastName);