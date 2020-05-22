File[] drivePath;

drivePath = File.listRoots();

for(File drive:drivePath)

    System.out.println("Drive Name: "+drive);