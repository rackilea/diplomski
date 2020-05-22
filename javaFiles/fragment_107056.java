public class Model {

    private IntegerProperty listNumber = new SimpleIntegerProperty();

    public int getListNumber() {
        return listNumber.get();
    }

    public IntegerProperty listNumberProperty() {
        return listNumber;
    }

    public void setListNumber(int listNumber) {
        this.listNumber.set(listNumber);
    }
}