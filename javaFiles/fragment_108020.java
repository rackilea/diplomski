public class Student {
    private Integer x = Integer.valueOf(1000);

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        if(x != null) {
           this.x = x;
        }
    }
}