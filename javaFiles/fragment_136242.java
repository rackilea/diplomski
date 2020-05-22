class Program {
    private static final DateTimeFormatter FORMATTER = 
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSxx");
    private final ZonedDateTime created;
    private final String id;
    private final List<ProgramStage> programStages;
    private final TrackedEntity trackedEntity;

    @JsonCreator
    public static Program of(
            @JsonProperty("id") final String id,
            @JsonProperty("created") final String created,
            @JsonProperty("trackedEntity") final TrackedEntity trackedEntity,
            @JsonProperty("programStages") final List<ProgramStage> programStages) {

        return new Program(
                id, 
                ZonedDateTime.parse(created, FORMATTER), 
                trackedEntity, 
                programStages);
    }

    public Program(
            final String id,
            final ZonedDateTime created,
            final TrackedEntity trackedEntity,
            final List<ProgramStage> programStages) {
        this.id = id;
        this.created = created;
        this.trackedEntity = trackedEntity;
        this.programStages = programStages;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public String getId() {
        return id;
    }

    public List<ProgramStage> getProgramStages() {
        return programStages;
    }

    public TrackedEntity getTrackedEntity() {
        return trackedEntity;
    }
}