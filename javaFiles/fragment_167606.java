import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Parent {

    @JsonUnwrapped
    private Intermediate intermediate;

    public Intermediate getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(Intermediate intermediate) {
        this.intermediate = intermediate;
    }
}