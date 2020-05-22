"CREATE TRIGGER " + OperationEntry.TRIGGER_NAME +
    " AFTER UPDATE " +
    " ON["+ OperationEntry.TABLE_NAME +"] " +
    " FOR EACH ROW " +
    " BEGIN " +
    " DECLARE changes VARCHAR(8000); " +
    " SET changes = '{'; " +
    " IF OLD. " + OperationEntry.COLUMN_ID + " <> " + " NEW. " + OperationEntry.COLUMN_ID + " THEN " +
    "SET changes = CONCAT(changes, );" +
    " END IF; " +
    " IF OLD. " + OperationEntry.COLUMN_COMPANY + " <> " + " NEW. " + OperationEntry.COLUMN_COMPANY + " THEN " +
    "SET changes = CONCAT(changes, );" +
    " END IF; " +
    " IF OLD. " + OperationEntry.COLUMN_BUILDING + " <> " + " NEW. " + OperationEntry.COLUMN_BUILDING + " THEN " +
    "SET changes = CONCAT(changes, );" +
    " END IF; " +
    " SET changes = CONCAT(changes, '}'); " +
    " END; ");