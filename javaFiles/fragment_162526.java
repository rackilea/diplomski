private Date empdob;

public void setEmpdobString(String s) {
    this.empdob = someDateFormatter.parse(s);
}

public Date getEmpdobDate() {
    return empdob;
}