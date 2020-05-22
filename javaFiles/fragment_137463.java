//more than 2 new lines
(?:[\u00A0\u2007\u202F\p{javaWhitespace}&&[^\n\r]])*(\n\r|\r\n|\n|\r)(?:(?:[\u00A0\u2007\u202F\p{javaWhitespace}&&[^\n\r]])*\1)+

//between 1 and 3 full stops
\.{1,3}"?

//up to 4 ! or ? in sequence
(!|\?){1,4}"?