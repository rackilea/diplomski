public static void main (String[] args) {
    DummyRequest request = new DummyRequest();
    request.setCode("Dummy Value");
    List<String> validateMessages = validate(request);
    if (validateMessages.size() > 0 ) {
        for (String validateMessage: validateMessages) {
            System.out.println(validateMessage);
        }
    }
}


Output:
--------
height may not be null
length may not be null
someField may not be null
someOtherField may not be null
breadth may not be null