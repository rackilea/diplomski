public String generateName() {
   Random generateName = new Random();
   String[] name = ...
   String[] lastname = ...

   return name[generateName.nextInt(19)] + " " + lastname[generateName.nextInt(19)];
}