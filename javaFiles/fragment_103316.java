class ReflectTest {
    Object o = null;
    public void setO(int i) {
        System.out.println("set int");
        o = i;
    }
    public void setO(Integer i) {
        System.out.println("set Integer");
        o = i;
    }
}