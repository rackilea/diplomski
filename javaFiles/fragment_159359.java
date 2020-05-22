FileWriter writer = new FileWriter("Students.txt", true);
writer.write(username);
writer.write(",");
writer.write(password);
writer.write(System.getProperty("line.separator"));//add the new line after writing your user credentials
writer.close();