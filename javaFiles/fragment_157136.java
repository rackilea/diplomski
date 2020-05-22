@JsonProperty("start_date")
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
public void setStartDate(Date startDate) {
    this.startDate = startDate;
}

@JsonProperty("start_date")
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
public void setEndDate(Date endDate) {
    this.endDate = endDate;
}