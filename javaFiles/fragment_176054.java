// Inside business layer:
public void businessMethod(...) {
    try {
        // Begin transaction.
        dataMethod1(...);
        dataMethod2(...);
        ...
        // Commit transaction.
    }
    catch (...) {
    }
}

// Inside data layer.
public void dataMethod1(...) {
    // Open connection.
    try {
        // Get data from database.
        // Manipulate data.
    }
    finally {
        // Close connection.
    }
}