Builder builder = FormParserFactory.builder();

    final FormDataParser formDataParser = builder.build().createParser(exchange);
    if (formDataParser != null) {
        exchange.startBlocking();
        FormData formData = formDataParser.parseBlocking();

        for (String data : formData) {
            for (FormData.FormValue formValue : formData.get(data)) {
                if (formValue.isFile()) {
                    // process file here: formValue.getFile();
                } 
            }
        }
    }