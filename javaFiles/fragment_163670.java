Example: 









public class PropertiesContacts {



    int _id;
    String _title;
    String _description ;

    public int getID(){
        return this._id;
    }


    public void setID(int id){
        this._id = id;
    }


    public String gettitle(){
        return this._title;
    }


    public void settitle(String title){
        this._title = title;
    }



    public String getdescription (){
        return this._description ;
    }


    public void setdescription (String description ){
        this._description  = description ;
    }


}



Set properties value in activity
Like

PropertiesContacts  obj=new PropertiesContacts ();
obj._id=1;
obj._title ="amit";
obj._description ="test";
insertNewRowInspectionPlan(obj);
Hope you will understan