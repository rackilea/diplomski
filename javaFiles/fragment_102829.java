@XmlRootElement
public class UsersList {


Map<Integer,Users> variabila;

public UsersList() {

}


public void setVariabila(HashMap<Integer,Users> collection) {
    this.variabila = new ArrayList(collection.values());
}
@XmlElement(name="getusers")
public ArrayList<Users> getUsers() {
            return variabila;
        }



    }