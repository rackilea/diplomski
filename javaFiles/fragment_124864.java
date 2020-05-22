//create the new HashSet
Set<Person> set = new HashSet<Person>();
//create your elements to be inserted
Person a= new Person("alice",45);
Person b= new Person("bob",41);
Person c= new Person("charlie",48);
//try to add "a". It will calculate hashCode from name field,
//which value is "alice"
set.add(a);
//you change the name here, but it won't affect the previous
//operation because the index for "a" was calculated using "alice",
//not "bob" and IT WONT BE RECALCULATED!
a.name="bob";
//try to add "b". It will calculate hashCode from name field,
//which value is "bob"
//as noted before, there's no index based on "bob"'s hashCode,
//so it will be added with no problems
set.add(b);
//try to add "c". It will calculate hashCode from name field,
//which value is "charlie"
set.add(c);