import java.io.Serializable;    

public class SubMainLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    public SubMainLevel() {

    }

    private String LineNo;
    private String arg2;
    private String RollNo;
    private String weight;
    private String folds;

    public String getLineNo() {
        return LineNo;
    }

    public void setLineNo(String lineNo) {
        LineNo = lineNo;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFolds() {
        return folds;
    }

    public void setFolds(String folds) {
        this.folds = folds;
    }

    @Override
    public String toString() {
        return "LineNo=" + getLineNo() + " arg2=" + getArg2() + " RollNo=" + getRollNo()
                + " weight=" + getWeight() + " folds=" + getFolds();
    }

}