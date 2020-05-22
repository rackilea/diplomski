Home h = new Home();
String[] sports = // existing array of sport names
String[] schools = // array of school names
for (int i =0; i< sports.length; i++) {
    h.add(new Sports(sports[i]), new School(schools[i]));
}