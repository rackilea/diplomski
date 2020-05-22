@ManyToMany
@JoinTable(name = "scanalerts",  schema = RfidConstants.SCHEMA,
  joinColumns = @JoinColumn(name = "scanid"),
  inverseJoinColumns = @JoinColumn(name = "alert_id")
)
private List<Alert> alerts;