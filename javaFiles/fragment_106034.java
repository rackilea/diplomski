public class MyNumber {
    private int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof MyNumber) {
            return (number == ((MyNumber) o).number);
        }
        else {
            return false;
        }
    }

    @Override
    public String toString(){
        return this.getClass().getName() + "(" + number + ")";
    }
}