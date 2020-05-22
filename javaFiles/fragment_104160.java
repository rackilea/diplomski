public static Document createTextDocument(int maxLength){
        return new TextDocument(maxLength);
    }

...

Document document = createTextDocument(5); // limit to 5 chars
textField1.setDocument(document);

document = createTextDocument(10); // limit to 10 chars
textField2.setDocument(document);