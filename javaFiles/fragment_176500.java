SomeObject someObject = (SomeObject) request.getSession().getAttribute("someObject");

if (someObject == null) {
    someObject = new SomeObject();
    request.getSession().setAttribute("someObject", someObject);
}

// Use someObject.