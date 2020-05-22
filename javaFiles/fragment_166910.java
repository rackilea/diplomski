package general;

public class BasicInstantiation {
private String name;

BasicInstantiation(String name){
    this.name = name;
}

public void setName(String name){
    this.name = name;
}

public String getName() {
    return name;
}

public static void main(String[] args) {
    try {
        BasicInstantiation bi = null;
        bi.setName("Romeo");
    }
    catch (NullPointerException ex){
        ex.printStackTrace();
    }

    try {
        BasicInstantiation bi1 = new BasicInstantiation("Romeo");
        bi1 = null;
        bi1.getName();          
    }
    catch (NullPointerException ex){
        ex.printStackTrace();
    }

}

}