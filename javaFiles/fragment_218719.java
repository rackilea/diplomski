Content subjContent = new Content().withData("Test of Amazon SES");
Message msg = new Message().withSubject(subjContent);

// Include a body in both text and HTML formats
Content textContent = new Content().withData("Hello - I hope you're having a good day.");
Content htmlContent = new Content().withData("<h1>Hello - I hope you're having a good day.</h1>");
Body body = new Body().withHtml(htmlContent).withText(textContent);
msg.setBody(body);