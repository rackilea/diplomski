// here we match the whole String, so we need start-of-input and 
// end-of-input delimiters
//                               | case-insensitive flag
//                               |   | beginning of input
//                               |   |                        | end of input
System.out.println(text.matches("(?i)^.*\\beat\\b.*\\byet\\b.*$"));