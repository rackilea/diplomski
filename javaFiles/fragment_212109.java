public int compareTo(Friendship another) {


       if(!this.getType().equals(another.getType()){
        //if type are not equal, so we might have at most one A

          if(this.getType.equals(TypeA)){ //on left side
             return -1;
          }

          if(another.getType().equals(TypeA)){ //or, on rightside
            return 1;
          }
        }
          //or we have on both sides or neither side
            return this.getUsername().compareTo(
                    another.getUsername());
        }