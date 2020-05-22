try {
    Get connection, statement, resultset
    Use connection, statement, resultset
    try {
        Get inputstream of resultset, outputstream
        Use inputstream of resultset, outputstream
    } finally {
        Close outputstream, inputstream of resultset
    }
} finally {
    Close resultset, statement, connection
}