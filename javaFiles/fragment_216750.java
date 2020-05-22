public class TestDTO {
    private String test1;
    private String test2;
    private String test3;

    //Default no argument constructor
    TestDTO() {
    }

    TestDTO(String test1, String test2, String test3) {
        this.test1 = test1
        this.test2 = test2
        this.test3 = test3
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    //And so on..

}