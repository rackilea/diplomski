@When("^user adds entry \"([^\"]*)\"$")
public void add_entry(String path) {
    designer.http()
        .client(todoClient)
        .send()
        .post("/todo")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        .payload(new ClassPathResource(path));
}