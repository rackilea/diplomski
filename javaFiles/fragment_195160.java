public class PassedExam {
    private String code;
    private Integer mark;

    public PassedExam(String code, int mark){
        this.code = code;
        this.mark = mark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "PassedExams{" +
                "code='" + code + '\'' +
                ", mark=" + mark +
                '}';
    }

}