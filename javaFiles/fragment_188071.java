class Score {
    @ManyToOne(optional=false)
    Competitor competitor;
    @ManyToOne(optional=false)
    Discipline discipline;
}