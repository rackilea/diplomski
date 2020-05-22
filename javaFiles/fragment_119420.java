@ManyToOne
//@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ParticipantId")
public Participant getParticipant() {
    return participant;
}