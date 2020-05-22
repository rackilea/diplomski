begin transaction;

try {
    save new record for document;
    save Word document in predefined directory, using record's ID as the filename;
} catch (Exception e) {
    rollback transaction;
    throw e; // Rethrow exception
}

commit transaction;