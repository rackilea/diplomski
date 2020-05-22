import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class JsonModel {
    private String name;
    private List<JsonModel> children;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<JsonModel> getChildren() {
        return children;
    }
    public void setChildren(List<JsonModel> children) {
        this.children = children;
    }
    public String toString(){
        return "name: "+name + ", children: {"+children+"}";
    }
}

public class Test{

    public static void main(String a[])
    {
        ArrayList<String[]> initialList= new ArrayList<String[]>();
        initialList.add(new String[]{"Alpha", "A1", "1", null});
        initialList.add(new String[]{"Alpha", "A1", "2", null});
        initialList.add(new String[]{"Alpha", "A2", "1", null});
        initialList.add(new String[]{"Alpha", "A2", "2", null});
        initialList.add(new String[]{"Beta", "A1", "1", null});
        initialList.add(new String[]{"Beta", "A1", "2", null});
        initialList.add(new String[]{"Beta", "A2", "1", null});
        initialList.add(new String[]{"Beta", "A2", "2", null});

        ArrayList<JsonModel> returnList = new ArrayList<JsonModel>();

        HashMap<String,HashMap<String,JsonModel>> tempMap = new HashMap<String, HashMap<String,JsonModel>>();
        HashMap<String,JsonModel> tempMapOuterMost = new HashMap<String, JsonModel>();

        // eg. 1,null
        JsonModel layer3Child = null;

        // eg. A1,{}
        JsonModel layer2Child = null;

        // eg. Alpha,{}
        JsonModel layer1Child = null;

        for(String[] myArray: initialList){

            // to set inner most object eg. 1,null
            layer3Child = new JsonModel();
            layer3Child.setName(myArray[2]);

            JsonModel layer4Child = new JsonModel();
            layer4Child.setName("PersonName");
            ArrayList<JsonModel> layer4Children = new ArrayList<JsonModel>();
            layer4Children.add(layer4Child);
            layer3Child.setChildren(layer4Children);

            // getting object of outermost model eg. Alpha,{}
            if (tempMap.containsKey(myArray[0])){
                layer1Child = tempMapOuterMost.get(myArray[0]);
            } else {
                layer1Child = new JsonModel();
                layer1Child.setName(myArray[0]);
                layer1Child.setChildren(new ArrayList<JsonModel>());
                returnList.add(layer1Child);

                tempMapOuterMost.put(myArray[0], layer1Child);
                tempMap.put(myArray[0], new HashMap<String,JsonModel>());
            }

            // getting the object at layer 2 eg. A1,{}
            if (tempMap.get(myArray[0]).containsKey(myArray[1])){
                layer2Child = tempMap.get(myArray[0]).get(myArray[1]);
            } else {
                layer2Child = new JsonModel();
                layer2Child.setName(myArray[1]);
                layer2Child.setChildren(new ArrayList<JsonModel>());

                layer1Child.getChildren().add(layer2Child);

                tempMap.get(myArray[0]).put(myArray[1], layer2Child);
            }

            layer2Child.getChildren().add(layer3Child);
        }

        System.out.println(returnList);
    }

}