// This connection is initialized beforehand and will not be
// closed automatically by try-with-resources
Connection conn = // ...

// The statement WILL always be closed, exception or not, before exiting the try block
try (Statement stmt = conn.createStatement())
{
    // This result set will NOT be closed (directly) by try-with-resources
    ResultSet rs = stmt.executeQuery(/*...*/);
}