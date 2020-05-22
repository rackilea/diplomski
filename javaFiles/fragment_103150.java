public class Person{

private String name;

public Person(String name){ this.name = name;}

public String getName(){ return this.name;}

@Override
public boolean equals(Object o){
  if ( !(o instanceof Person)){ return false;}
  Person p = (Person)o;
  boolean nameE = this.name == null ? p.getName() == null : this.name.equals(p.getName());
  boolean hashE = nameE ? true : randomTrueOrFalse();
  // the only moment you're sure hashE is true, is if the previous check returns true.
  // in any other case, it doesn't matter whether they are equal or not, since the nameCheck returns false, so in best case, it's redundant
  return nameE && hashE;
}

@Override
public int hashCode(){
  int hash = generateValidHashCode();
  return hash;
}

}