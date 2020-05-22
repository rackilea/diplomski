try {
            statementBegins();

            clearWarnings();

            if (!this.batchHasPlainStatements && this.connection.getRewriteBatchedStatements()) {

                if (canRewriteAsMultiValueInsertAtSqlLevel()) {
                    return executeBatchedInserts(batchTimeout);
                }

                if (this.connection.versionMeetsMinimum(4, 1, 0) && !this.batchHasPlainStatements && this.batchedArgs != null
                        && this.batchedArgs.size() > 3 /* cost of option setting rt-wise */) {
                    return executePreparedBatchAsMultiStatement(batchTimeout);
                }
            }

            return executeBatchSerially(batchTimeout);
        } finally {
            this.statementExecuting.set(false);

            clearBatch();
        }