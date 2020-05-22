private Long ballotId;

@Column(name = "ballot_id")
public Long getBallotId() {
    return ballotId;
}

public void setBallotId(Long ballotId) {
    this.ballotId = ballotId;
}