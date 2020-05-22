if (isInBatchWritingMode(session)) {
    // if there is nothing returned and we are not using optimistic locking then batch
    //if it is a StoredProcedure with in/out or out parameters then do not batch
    //logic may be weird but we must not batch if we are not using JDBC batchwriting and we have parameters
    // we may want to refactor this some day
    if (dbCall.isNothingReturned() && (!dbCall.hasOptimisticLock() || getPlatform().canBatchWriteWithOptimisticLocking(dbCall) ) 
        && (!dbCall.shouldBuildOutputRow()) && (getPlatform().usesJDBCBatchWriting() || (!dbCall.hasParameters())) && (!dbCall.isLOBLocatorNeeded())) {
        // this will handle executing batched statements, or switching mechanisms if required
        getActiveBatchWritingMechanism().appendCall(session, dbCall);
        //bug 4241441: passing 1 back to avoid optimistic lock exceptions since there   
        // is no way to know if it succeeded on the DB at this point.
        return Integer.valueOf(1);
    } else {
        getActiveBatchWritingMechanism().executeBatchedStatements(session);
    }
}