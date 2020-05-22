public static Result create() {

    Form<CSVData> formData = Form.form(CSVData.class).bindFromRequest();

}    

public static Result update() {

    Form<CSVData> formData = Form.form(CSVData.class).bindFromRequest();

    if( !formData.hasErrors() ){
        if(formData.field("name").value().equals( .... ) {
            // do some check here
            // add ValidationError if needed
        }
    }

}