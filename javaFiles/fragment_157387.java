try {
    // code that fails
} catch (PSQLException e) {
    if (PSQLState.SYNTAX_ERROR.getState().equals(e.getSQLState())) {
        // handle syntax error
    } else }
        // handle other error
    }
}