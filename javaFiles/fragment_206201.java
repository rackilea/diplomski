@ElementCollection
@CollectionTable(
        name="CANDIDATE_SKILLS_TABLE",
        joinColumns=@JoinColumn(name="UUID")
)
private List<CandidateSkills> skills;