class Owner {

   Bar b = new Bar(this);

   dostuff(){...}
}    

class Bar {
   Bar(Owner owner) {
      owner.dostuff();
   }
}