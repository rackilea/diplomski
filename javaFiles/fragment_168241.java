@Override
public boolean equals(Object obj) {
     if (obj == this){
        return true;
    }
    if (obj == null || obj.getClass() != this.getClass()){
        return false;
    }

    Person guest = (Person) obj;
    return id == guest.id
             &&(firstName == guest.firstName
                 || (firstName != null && firstName.equals(guest.getFirstName())))
             &&(lastName == guest.lastName
                 || (lastName != null && lastName .equals(guest.getLastName())));
}

@Override
public int hashCode(){
    final int prime = 31;
     int result = 1;
    result = prime * result
            + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + id;
     result = prime * result
            + ((lastName == null)? 0 : lastName.hashCode());
    return result;
 }