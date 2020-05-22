NamedThing person1 = new Person("Jon", date1);
NamedThing person2 = new Person("Jon", date2);
NamedThing thing = new NamedThing("Jon");

int comparison1 = person1.compareTo(thing);
int comparison2 = person2.compareTo(thing);
int comparison3 = person1.compareTo(person2);
int comparison4 = thing.compareTo(person1);