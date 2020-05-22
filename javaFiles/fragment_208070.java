@Transient
private Duration myDuration;

@Column(name="DURATION")
String myDurationString;

@PostLoad
public void init() {
  this.myDuration = this.myDurationString == null ? null : Duration.parse(this.myDurationString);
};

public Duration getMyDuration() {
  return this.myDuration;
}

public void setMyDuration(Duration _myDuration) {
  this.myDurationString = _myDuration == null ? null : _myDuration.toString();
}