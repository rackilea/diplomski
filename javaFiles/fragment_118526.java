public void submittingForm() throws Exception {
   WebClient webClient = new WebClient();
   HtmlPage page1 = webClient.getPage("http://some_url");
   HtmlForm form = page1.getFormByName("myform");
   HtmlSubmitInput button = form.getInputByName("submitbutton");
   HtmlTextInput textField = form.getInputByName("userid");
   textField.setValueAttribute("root");
   HtmlPage page2 = button.click();
}