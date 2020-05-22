@Transactional //either this...
public void doStuff(final ResultCommand command) {
    //begin transaction <-- ...or this
    final BaseResult result = em.find(BaseResult.class, command.getResultId());
    result.apply(command);
    //end transaction
}