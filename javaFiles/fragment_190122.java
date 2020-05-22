if (setNum.matches(regexStr))
where regexStr can be:

//matches numbers only
String regexStr = "^[0-9]*$"

//matches 10-digit numbers only
String regexStr = "^[0-9]{10}$"

//matches numbers and dashes, any order really.
String regexStr = "^[0-9\\-]*$"

//matches 9999999999, 1-999-999-9999 and 999-999-9999
String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$"