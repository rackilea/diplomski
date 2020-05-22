final String value;
if (itemdescription == null || itemdescription.length() <= 0) {
    value = "_";
} else if (itemdescription.length() <= 38) {
    value = itemdescription;
} else { 
    value = itemdescription.substring(0, 38);
}
pstmt2.setString(3, value);