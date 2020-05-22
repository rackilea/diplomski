Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z\\s]+$"); 
// creates a regex pattern that can match a character followed by one or more characters or space
example : `ab` or `asa[space]` but not `a2` or `a` or `2`

Pattern pattern = Pattern.compile("\\d{10}");
// creates a regex pattern which can match exactly 10 digits
example : 1234567890