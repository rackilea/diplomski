@JsonIgnore
@LastModifiedDate
private LocalDate lastUpdated;

@JsonProperty("lastUpdated")
public LocalDate getLastUpdated() {
    return lastUpdated;
}

@JsonIgnore
public void setLastUpdated(LocalDate lastUpdated) {
    this.lastUpdated = lastUpdated;
}