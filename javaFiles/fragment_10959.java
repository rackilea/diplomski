class Checks {

    String check;
    boolean completed;
    Checks (String check, boolean completed) {
        this.check = check;
        this.completed = completed;
    }
    public String getCheck() {
        return check;
    }
    public void setCheck(String check) {
        this.check = check;
    }
    public boolean getCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}