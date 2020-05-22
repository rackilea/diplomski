String query = "SELECT Description,(Select Name,Id from Contacts) , Account.Name, (Select Id from Contacts) from Account";

// Remove all subqueries (things in parenthesis)
// Remove doubled commas (even with space in between)
// Remove a comma before the from
String answer = query
    .replaceAll("\\(.*?\\)", "")
    .replaceAll(",\\s*,", ",")
    .replaceAll(",\\s*from", " from");