String[] jsonData = request().body().asFormUrlEncoded().get("records")
MyForm myForm = new MyForm();
// Record should act as form, because each JSON string data contain this type
Form<Record> form = Form.form(Record.class);
// parse the JSON string and assign iterator 
Iterator<JsonNode> it = Json.parse(jsonData[0]).iterator(); 
// assign to the MyForm instance
while (it.hasNext()) {
    formData.records.add(form.bind(it.next()).get()); // bind the JSON and add
}