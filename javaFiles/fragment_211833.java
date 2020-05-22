public class Main {

    public static void main(String[] args) {

        ArrayList<MyCustomObject> list = new ArrayList<>();
        list.Add(new MyCustomObject(true));
        list.Add(new MyCustomObject(false));
        list.Add(new MyCustomObject(true));
        list.Add(new MyCustomObject(true));

        ....

        for (MyCustomObject potentialMatch: list) {
            if(obj.visible) 
                doSomething(potentialMatch);
        }
    }

}