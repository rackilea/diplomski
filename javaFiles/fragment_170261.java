class Job {

    @Id
    //stuff...


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn (name="authorization_id", nullable = false, updatable = false, insertable = false)
    private Authorization authorization;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn (name="filter_id", nullable = false, updatable = false, insertable = false)
    private Filter filter;
}