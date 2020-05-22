public String getFilterCondition(Group group) {

    String sendMail = group.getEmail();
    String phone = group.getPhone();
    String gender = group.getGender();
    String concat = "where ";

    String query = "select * from member ";
    if (sendMail != null) {
        query += concat + "sendMail='" + sendMail + "' ";
        concat = "and ";
    }
    if (phone != null) {
        query += concat + "phone='" + phone + "'";
        concat = "and ";
    }
    if (gender != null) {
        query += concat + "gender='" + gender + "'";
    }

    return query;

}