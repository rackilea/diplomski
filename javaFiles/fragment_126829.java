public void printFormData(Object form) {
    System.out.println(form.getClass() + " " + form);

    if (form instanceof Element) {
        NodeList inputs = ((Element)form).getElementsByTagName("input");
        for (int i = 0 ; i < inputs.getLength(); i++) {
            Node input = inputs.item(i);
            Element inputEl = (Element)input ;

            String id = inputEl.getAttribute("id");
            String value = (String) engine.executeScript(id+".value");

            System.out.printf("%s : %s %n", id, value);
        }
    }
}