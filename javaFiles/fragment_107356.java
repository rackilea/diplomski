public GameEntity addParticipant(TeamEntity team, GameParticipant.Alignment alignment) { 
    ParticipantEntity pe = ParticipantEntity.create(team, alignment)
    participants.add(pe);
    pe.setGame(this);
    return this; 
}