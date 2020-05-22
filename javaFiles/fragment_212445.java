try (Connection writeConn = DatabaseManager.getConnection(true);
            final DSLContext writeContext = DatabaseManager.getBuilder(writeConn);
            InsertQuery<UserProgramAssignmentsRecord> programAssignmentsUpdateQuery = writeContext
                    .insertQuery(AccessControlWriteDAO.userProgramAssignments)) {
        programAssignmentsUpdateQuery.onDuplicateKeyUpdate(true);

        programAssignments
                .forEach(assignment -> AccessControlWriteDAO.addRecordToUpsert(programAssignmentsUpdateQuery,
                        assignment.toRecord(), assignment.toExcludedMap()));

        if (!programAssignments.isEmpty()) {
            if (AccessControlWriteDAO.logger.isInfoEnabled()) {
                AccessControlWriteDAO.logger.info(writeContext.renderInlined(programAssignmentsUpdateQuery));
            }
            programAssignmentsUpdateQuery.execute();
        }
    } catch (final SQLException e) {
        throw new DAOException(e.getMessage(), e);
    }