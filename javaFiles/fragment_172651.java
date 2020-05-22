import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author blj0011
 */
public class DataModel
{
    private final ObservableList<String> listViewData = FXCollections.observableArrayList();
    private final ObservableList<String> comboBoxwData = FXCollections.observableArrayList();
    private final StringProperty textAreaDataProperty = new SimpleStringProperty();

    public DataModel()
    {
    }

    public void loadListViewData()
    {
        listViewData.addAll(retrieveListViewDataFromDB());
    }

    public ObservableList<String> getListViewData()
    {
        return listViewData;
    }

    public void loadComoBoxData()
    {
        comboBoxwData.addAll(retrieveComboBoxDataFromDB());        
    }

    public ObservableList<String> getComboBoxData()
    {
        return comboBoxwData;
    }    

    public void loadTextAreaData()
    {
        textAreaDataProperty.set(retrieveTextAreaDataFromDB());
    }

    public StringProperty getTextAreaDataProperty()
    {
        return textAreaDataProperty;
    }

    public String getTextAreaData()
    {
        return textAreaDataProperty.get();
    }


    //Private methods that fake retrieving data from the database.
    private List<String> retrieveListViewDataFromDB()
    {
        List<String> dataFromDB = new ArrayList();
        for(int i = 0; i < 1000; i++)
        {
            dataFromDB.add(Integer.toString(i));
        }

        return dataFromDB;
    }    

    private List<String> retrieveComboBoxDataFromDB()
    {
        List<String> dataFromDB = new ArrayList();
        dataFromDB.add("A");
        dataFromDB.add("B");
        dataFromDB.add("C");
        dataFromDB.add("D");
        dataFromDB.add("E");
        dataFromDB.add("F");

        return dataFromDB;
    }

    private String retrieveTextAreaDataFromDB()
    {
        return "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";  
    }
}