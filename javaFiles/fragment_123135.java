//frnd1.starContact = true;
    System.out.println("Entry present>"+phoneBook.contacts.contains(frnd1));

    if(phoneBook.contacts.remove(frnd1)){
        System.out.println("removed");
        frnd1.starContact = true;
        phoneBook.contacts.add(frnd1);
    }


@Override
public int compareTo(Contact otherContact) {
    if(otherContact.phoneNo == this.phoneNo){
        return 0;
    }
    if(this.starContact && otherContact.starContact){
        return this.timeAdded.before(otherContact.timeAdded)?-1:1; //impossible to add 2 contacts at the same time
    }else if(this.starContact){
        return -1;
    }else if(otherContact.starContact){
        return 1;
    }else{
        //simple Contacts
        return this.name.compareTo(otherContact.name);
    }
}