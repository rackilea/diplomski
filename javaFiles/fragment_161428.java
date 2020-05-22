@ElementCollection
@AttributeOverrides({
 @AttributeOverride(name="key.year",
 column=@Column(name="YEAR1")),
 @AttributeOverride(name="value.workedHours",
 column=@Column(name="WORKED_H"))
})
private Map<CalenderWeek, WorkedTime> workedTimeMap;