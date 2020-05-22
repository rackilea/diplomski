public class mProgram {
    public class NrlData {
        ...
    }

    public static void main(String[] args) {
        mProgram.NrlData nrlData = new mProgram().new NrlData();
    }

    public void aMethod() { // accessing inner class from the "this" instance
        NrlData nrlData = new NrlData();
}