final String result;
if (isValue == null) {
    result = "";
} else if (isValue) {
    result = "T";
} else {
    result = "F";
}
return result;