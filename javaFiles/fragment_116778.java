public class MyClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyClassB obj = new MyClassB();
        obj.reshape(0, 2, 4, 6);
    }

}

class MyClassA {

    public void setBounds(int x,int y,int width,int height) {
        reshape(x, y, width, height); // This calls the child class reshape method if it is overridden and hence can be recursive call

    }

    public void reshape(int x,int y,int width,int height) {

    }
}

class MyClassB extends MyClassA {

    public void reshape (int x, int y, int w, int h) {
        super.setBounds(x, y, w, h);
    };

}