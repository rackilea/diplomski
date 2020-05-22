List<YourClass> list = new ArrayList<YourClass>();
list.add(new Person());

for (YourClass item : list){
      System.out.println(item);  //here it will automaticly use the overridden toString in your class
}