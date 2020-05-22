public String toString(){
    if(this.suivant == null)
        return(city.toString() + "Fin");
    else{
        return(city.toString()+"->" + this.suivant.toString());
    }


}