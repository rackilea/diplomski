final class Model{
 final String firstPart;
 final String secondPart;
 final int hashCode;
  Model(String s){
   String[] splitted=s.split(":");
   firstPart=splitted[0];
   secondPart=splitted[1];
   hashCode=Objects.hash(firstPart.toLowerCase(),secondPart);

  }

  @Override
  public boolean equals(Object o){
   String[] splitted=o.toString().split(":");
   return firstPart.equalsIgnoreCase(splitted[0]) && secondPard.equals(splitted[1]);
  }

  @Override
  public int hashCode(){
   return hashCode;
  }

  @Override
  public String toString(){
    return firstPart+":"+secondPart;
  }
}