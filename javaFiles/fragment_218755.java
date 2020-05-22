public void addPuppy(Puppy puppy){
           if (this.puppies == null){
               this.puppies = new HashSet<Puppy>();
           }
           puppy.setDog(this); // <--This will set dog as parent in puppy class
           this.puppies.add(puppy);
    }