@Override
public boolean equals(Object o){
    if( o == null ){
        return false;
    }
    if(o == this){
        return true;
    }
    if (!(o instanceof Item)){
        return false;
    }
    Item a = (Item)o;
    if( hasSameIsbn(a) ){
        return true;
    }
    else{
       return false;
    }
}

@Override
public int hashCode(){
    return (41 + this.isbn.hashCode());
}