DIRECTORY directory = new DIRECTORY();
directory.addSchool("A1", "Point Grey");
directory.addSchool("B1", "Prince of Wales");

SCHOOL schoolA1 = directory.getSchoolById("A1");

schoolA1.addStudent("kent", "43");
schoolA1.addStudent("Winnie", "19");
schoolA1.addStudent("Jane", "18");

SCHOOL schoolB1 = directory.getSchoolById("B1");
schoolB1.addStudent("Steven", "11");
schoolB1.addStudent("Michelle", "30");
schoolB1.addStudent("Ronald", "20");