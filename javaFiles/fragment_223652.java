@Column(name = "END_TIME")
private Date endDate = new Date();

public void setEndDate(Date endDate) {
  this.endDate = endDate;
}

public Date getEndDate() {
    return endDate;
}