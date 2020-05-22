public class Equals {

    public void method(){
        equals("");
    }
    @Override
    public boolean equals(Object other) {
        System.out.println("I am being compared to '"+other+"'");
        return super.equals(other);
    }
}