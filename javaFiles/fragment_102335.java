public class TestMain {

private  InnerFirst first;
private InnerSecond second;

private int outerData = 30;

class InnerFirst{
    private InnerFirst() {
        first = this;
    }



    private int data1 = 40;

    public int getData() {
        return data1;
    }

    public void setData(int data) {
        this.data1 = data;
    }

    void msg(){
        System.out.println("Inner data is : "+data1+" and outer data is : "+outerData);
    }
}

class InnerSecond{
    private InnerSecond() {
        second = this;
    }

    private int data2 = 40;

    public int getData() {
        return data2;
    }

    public void setData(int data) {
        this.data2 = data;
    }

    void msg(){
        System.out.println("Inner data is : "+data2+" and outer data is : "+outerData);
    }
}



private InnerFirst getFirst() {
    return first;
}


public static void main(String[] args) {
    // TODO Auto-generated method stub
    TestMain newClass = new TestMain();
    TestMain.InnerFirst newInnerClass = newClass.new InnerFirst();
    System.out.println(newClass.getFirst().getData());        

    newInnerClass.setData(50);

       newInnerClass.msg();

}