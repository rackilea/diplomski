try {
    Get connection, statement, resultset
    Use connection, statement, resultset
    Get inputstream of resultset
} finally {
    Close resultset, statement, connection
}

try {
    Get outputstream
    Use inputstream of resultset, outputstream
} finally {
    Close outputstream, inputstream of resultset
}