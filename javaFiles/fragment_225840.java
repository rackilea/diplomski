private String baseUrl = "http://www.hiddenlink.com/";
private String url = "";

btnSearchStudent.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        url = baseUrl + txtStudentID.getText().toString();
        new JSONParse().execute();
    }
});