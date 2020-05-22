public class CartOrder  {
    List<Data> data;

    public CartOrder () {
        data = new ArrayList<Data>();
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public void addData(Data data) {
        this.data.add(data);
    }

    class Data {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}