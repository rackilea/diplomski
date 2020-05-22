public class Band {

private String bandName;
private ArrayList<String> musician = new ArrayList<String>();
private ArrayList<String> songs = new ArrayList<String>();

public String getBandName(){
   return this.bandName;
}

public void setBandName(String bandName){
   this.bandName = bandName;
}

//And like that for the other two attributes. That way the classes that need access
// to these will either use a "get" method or a "set" method without directly 
// accessing the attributes. 

}