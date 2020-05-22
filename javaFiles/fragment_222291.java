public class UserDetails {
    private String time;
    private String age;
    private Map<String, String> prop = new HashMap<String, String>();
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public Map<String, String> getProp() {
        return prop;
    }
    public void setProp(Map<String, String> prop) {
        this.prop = prop;
    }   
}