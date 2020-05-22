public class A {

    private Duration availTime;

    // for json output of duration as string 
    @JsonFormat(shape = Shape.STRING)
    public Duration getAvailTime() {
        return availTime;
    }

    public void setAvailTime(Duration availTime) {
        this.availTime = availTime;
    }
}