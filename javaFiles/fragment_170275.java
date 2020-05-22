@override
public boolean equals(Object o){
     boolean equals = true;
     if(o instanceof Music){
        //here, we need to compare all the fields in music
        //repeat for title, genre, duration, year, etc.

        if(!(Music) o.artist.equals( this.artist){
             equals = false;
        }
    }
    return equals;
}