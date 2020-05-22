public class IdCounter {

    private static Integer nextId;

    static int getNextId(){
        if (nextId == null){
            //read file and get highest ID
        }
        return nextId++;
    }
}


public class addRecord {

    private String name;
    private int ID;
    private int age;
    private int height;

    private void saveRecord(){
        if(ID==0){
            ID = IdCounter.getNextId();
        }
    }
}