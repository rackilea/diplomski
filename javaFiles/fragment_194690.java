abstract class ParentPlanItem <E extends PlanItem> extends PlanItem {
    // Moved here from PlanItem:
    private ObservableList<E> childPlanItems = FXCollections.observableArrayList();
    // You might also need these:
    private Supplier<E> childConstructor;
    private unaryOperator<E> childCopyConstructor;
}