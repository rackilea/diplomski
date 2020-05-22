public class CustomChangeMove extends AbstractMove<VehicleRoutingSolution> {

private Customer customer;
private Customer toPreviousStandstill;

private Customer oldTrailingEntity;
private Customer newTrailingEntity;


public CustomChangemove(Customer customer, Customer toPreviousStandstill, Customer oldTrailingEntity, Customer newTrailingEntity) {
    this.customer = customer;
    this.toPreviousStandstill = toPreviousStandstill;
    this.oldTrailingEntity = oldTrailingEntity;
    this.newTrailingEntity = newTrailingEntity;
}

@Override
protected void doMoveOnGenuineVariables(ScoreDirector<VehicleRoutingSolution> scoreDirector) {
Standstill oldPreviousStandstill = customer.getPreviousStandstill();

    // move object
    scoreDirector.beforeVariableChanged(customer, "previousStandstill" );
    customer.setPreviousStandstill(toPreviousStandstill);
    scoreDirector.afterVariableChanged(customer, "previousStandstill");

    //fix old chain
    if (oldTrailingEntity != null) {
      scoreDirector.beforeVariableChanged(oldTrailingEntity, "previousStandstill" );
      oldTrailingEntity.setPreviousStandstill(oldPreviousStandstill);
      scoreDirector.afterVariableChanged(oldTrailingEntity, "previousStandstill");
}

    //fix new chain
    if (newTrailingEntity != null) {
      scoreDirector.beforeVariableChanged(newTrailingEntity, "previousStandstill" );
      newTrailingEntity.setPreviousStandstill(customer);
      scoreDirector.afterVariableChanged(newTrailingEntity, "previousStandstill");
    }
}


 @Override
  public boolean isMoveDoable(ScoreDirector<VehicleRoutingSolution> scoreDirector) {
    return !Objects.equals(customer.getPreviousStandstill(), toPreviousStandstill) ||
        !Objects.equals(customer.getNextCustomer(), toPreviousStandstill);
  }

  @Override
  protected AbstractMove<VehicleRoutingSolution> createUndoMove(ScoreDirector<VehicleRoutingSolution> scoreDirector) {
    return new MultidropChangeMove(customer, customer.getPreviousStandstill(), newTrailingEntity, oldTrailingEntity);
  }

 @Override
  public Collection<?> getPlanningEntities() {
//    return Arrays.asList(customer, newTrailingEntity, oldTrailingEntity);
    return Collections.singletonList(customer);
  }

  @Override
  public Collection<?> getPlanningValues() {
//    return Arrays.asList(customer.getPreviousStandstill(), newTrailingEntity.getPreviousStandstill(), oldTrailingEntity.getPreviousStandstill());
    return Collections.singleton(customer.getPreviousStandstill());
  }