public class MyClass {

    @JsonProperty("status")
    Object status;

    public boolean isStatus() {
        return Boolean.valueOf(status.toString());
    }

    public void setStatus(Object status) {
        if(status instanceof Boolean){
            this.status = status;
        }else if(status instanceof String){
            this.status = status.toString().equals("free");
        }
    }

    @Override
    public String toString() {
        return "MyClass [status=" + status.toString() + "]";
    }

}