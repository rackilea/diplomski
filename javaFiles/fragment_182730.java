public class Workers {


    @SerializedName("userid")
    private String userid;
    @SerializedName("username")
    private String username;
    @SerializedName("job")
    private String job;
    @SerializedName("age")
    private String age;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}