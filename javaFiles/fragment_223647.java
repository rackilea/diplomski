public class DataObject{

    private DataObject(){} // only one instance allowed
    public JSONArray telefone;

    public set_values(){
        // set your JSON stuff here
        telefone = data.getJSONArray("telefones");        
    }

}