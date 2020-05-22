public class Child extends Parent {
    public String word = "Only for demonstration purposes - do not hide fields!";

    public Child() {
        super.word = "Mutating the hidden field.";
    }
}