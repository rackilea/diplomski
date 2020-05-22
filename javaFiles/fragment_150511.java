public class Tester {

    private <T> ArrayList<T> getModels(Class<T> type) {
        ArrayList<T> arrayList = new ArrayList<T>();
        return arrayList;
    }


    public static void main(String[] args) {
        Data data = new Data(12, "test_12");
        Magic magic = new Magic(123, "test_123");

        Tester t = new Tester();

        ArrayList<Data> datas = (ArrayList<Data>) t.getModels(Data.class);
        datas.add(data);
        for(Data data2 : datas) {
            System.out.println(data2);
        }

        ArrayList<Magic> magics = (ArrayList<Magic>) t.getModels(Magic.class);
        magics.add(magic);
        for(Magic magic2 : magics) {
            System.out.println(magic2);
        }

    }

}