@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "day_idday", nullable = false, insertable = false, updatable = false)
private Day day;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "timeslot_idtimeslot", nullable = false, insertable = false, updatable = false)
private Timeslot timeslot;