public class zuordnung implements ZuordnungInterface {
public ArrayList<String> Zuordnung(ArrayList<String> rawList){

    ArrayList<String> computedList = (ArrayList<String>) rawList.clone();

    if (Model.getSomeString().equals("Some other string")) {
        computedList.add("Yeah, I loaded an external Java class");
    }


    return computedList;
}}