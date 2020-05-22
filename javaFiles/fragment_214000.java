public class MyRichTextArea extends RichTextArea {

    public MyRichTextArea() {

        addInitializeHandler(new InitializeHandler() {

            @Override
            public void onInitialize(InitializeEvent ie) {

                Document document = IFrameElement.as(getElement()).getContentDocument();
                BodyElement body = document.getBody();
                body.setAttribute("style", "font-family: Arial Unicode MS,Arial,sans-serif;");
            });
        }
    }
}