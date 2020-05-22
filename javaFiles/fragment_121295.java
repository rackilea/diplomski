public class Data<T>{

    private T children = null;

    public T getChildren(){
        return children;
    }

    public void setChildren(T children){
        this.children = children;
    }
}

public class DataRunner {
    public static void main(String[] args){
        Data<List<Data>> data = new Data<>();

        Data<List<Data>> subDataOne = new Data<>();
        subDataOne.setChildren(new ArrayList<>());

        Data<Boolean> subDataTwo = new Data<>();
        subDataTwo.setChildren(true);

        List<Data> listData = new ArrayList<>();

        listData.add(subDataOne);
        listData.add(subDataTwo);

        data.setChildren(listData);

        // {"children":[{"children":[]},{"children":true}]}
        System.out.println(new Gson().toJson(data));
    }
}