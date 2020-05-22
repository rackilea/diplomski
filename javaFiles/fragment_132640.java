class Member {
    private String name, no, dob;
    public Member(String name, String no, String dob) {
       this.name = name;
       this.no = no;
       this.dob = dob;
    }
    public String getName() { return this.name; }
    public String getNo() { return this.no; }
    public String getDOB() { return this.dob; }
}