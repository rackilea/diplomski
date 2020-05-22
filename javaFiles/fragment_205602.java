public ArrayList<Tier> tiere; // you forgot to initialize this ArrayList

 @Override
  public boolean add(Tier t){
      ArrayList<Tier> neu= new ArrayList<Tier>(); 
      if(t.gibLaut().equalsIgnoreCase("Wau! Wau!")){
          return neu.add(t); // this list is local to the method, you should be adding to tiere
          }
      else {
          return false;
      } }


  @ Override 
  public boolean addAll(ArrayList<Tier> tiere){
      ArrayList<Tier> neu= new ArrayList<Tier>(); // remove this list
     return tiere.addAll(neu); // should be this.tiere.addAll(tiere);

  }

  @Override
  public boolean remove(Tier t){
      ArrayList<Tier> neu= new ArrayList<Tier>(tiere.size()); // remove this
      if(!t.gibLaut().equalsIgnoreCase("Wau! Wau!")){
          return neu.remove(t); // should remove from tiere
      }
      else{
          return false;
      }

  }

@Override
public ArrayList<Tier> getTiere() {
    return new ArrayList<Tier>(); // should either return tiere or a copy of it (i.e. new ArrayList<Tier>(tiere))

}