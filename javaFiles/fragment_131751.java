public class Foo {

    private DateInterval dateInterval;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="startDate", column=@Column(nullable=true)),
        @AttributeOverride(name="endDate", column=@Column(nullable=true))
    })
    public DateInterval getDateInterval() { return this.dateInterval; }
    public void setDateInterval(DateInterval dateInterval) { this.dateInterval = dateInterval; }

}