@Temporal(value = TemporalType.TIME)
@Column(name = "START_TIME")
public Date getStartTime () {
    return startTime;
}



@Temporal(value = TemporalType.TIME)
@Column(name = "END_TIME")
public Date getEndTime () {
    return endTime;
}