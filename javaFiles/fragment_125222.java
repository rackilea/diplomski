// assuming the editorText is the contents of the edit window
String[] statements = editorText.split(";");

int statementCharactersProcessed = 0;

// assuming caret is at position caretIndex

int statementIndex = 0;
String statement;
while (caretIndex>statementCharactersProcessed+1) {
    // re-add the missing ;
    statement = statements[statementIndex++] + ";";
    statementCharactersProcessed += statement.length;
}

// statement should now be the value you're looking for