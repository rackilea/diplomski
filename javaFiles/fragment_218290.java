List<DtaMessage> msgList = new ArrayList<DtaMessage>();
boolean isResult = stmt.execute();

// Skip over update counts.  
while (!isResult) {
    if (stmt.getUpdateCount() == 0)
        // End of results.
        return msgList;
    isResult = stmt.getMoreResults();
}


// Process first result set.
ResultSet rs = stmt.getResultSet();
while (rs.next())
{
    DtaMessage msg = PopulateMessage(rs, isLoadRaw);
    msgList.add(msg);
}
rs.close();

// Skip over update counts.
isResult = stmt.getMoreResults();
while (!isResult) {
    if (stmt.getUpdateCount() == 0)
        // end of results.
        return msgList;
    isResult = stmt.getMoreResults();
}

// Process second result set.
rs = stmt.getResultSet();
while (rs.next())
{
    // process.
}
rs.close();
return msgList;