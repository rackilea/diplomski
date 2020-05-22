public interface HistoryDao<
    B extends UpdatableRecord<B>, 
    H extends UpdatableRecord<H>
> extends TableDao<H> {
    default void saveHistoryForIds(List<Integer> ids) {
        HashMap<TableField<H, ?>, TableField<B, ?>> mappings = setUpHistoryMapping();
        List<TableField<H, ?>> tableFields = new ArrayList<>(mappings.keySet());
        jooq().insertInto(table(), tableFields);
    }

    HashMap<TableField<H, ?>, TableField<B, ?>> setUpHistoryMapping();
}

class MyClassHere implements HistoryDao<
    ApprovalWorkflowRecord, 
    ApprovalWorkflowHistoryRecord
> {

    @Override
    public HashMap<
        TableField<ApprovalWorkflowHistoryRecord, ?>, 
        TableField<ApprovalWorkflowRecord, ?>
    > setUpHistoryMapping() {
        HashMap<
            TableField<ApprovalWorkflowHistoryRecord, ?>, 
            TableField<ApprovalWorkflowRecord, ?>
        > x = new HashMap<>();

        x.put(APPROVAL_WORKFLOW_HISTORY.ID, APPROVAL_WORKFLOW.ID);
    }
}