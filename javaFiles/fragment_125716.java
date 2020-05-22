public class ListExample {

    public static void main(String[] args) {
        List<Model> models = new ArrayList<>();

        // TODO: First create your model and add to models ArrayList, to prevent NullPointerException for trying this example

        // Print the name from the list....
        for(Model model : models) {
            System.out.println(model.getName());
        }

        // Or like this...
        for(int i = 0; i < models.size(); i++) {
            System.out.println(models.get(i).getName());
        }
    }
}

class Model {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}