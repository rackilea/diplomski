public class Tester {

    private <T> ArrayList<T> getModel() {
        ArrayList<T> arrayList = new ArrayList<T>();
        return arrayList;
    }


    public static void main(String[] args) {
        Data data = new Data(12, "test_12");
        Magic magic = new Magic(123, "test_123");

        Tester t = new Tester();

        ArrayList<Data> datas =  t.getModel();
        datas.add(data);
        for(Data data2 : datas) {
            System.out.println(data2);
        }

        ArrayList<Magic> magics = t.getModel();
        magics.add(magic);
        for(Magic magic2 : magics) {
            System.out.println(magic2);
        }

    }

}