try {
    Get connection, statement, resultset
    Use connection, statement, resultset
    Get inputstream of resultset
    Copy inputstream of resultset
} finally {
    Close resultset, statement, connection
}

try {
    Get outputstream
    Use copy of inputstream, outputstream
} finally {
    Close outputstream, copy of inputstream
}