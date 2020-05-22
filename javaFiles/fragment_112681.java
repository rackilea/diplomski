HtmlElement fakeButton = page.createElement("button");
button.setAttribute("type", "submit");

// add the button to the form
form.appendChild(fakeButton );
fakeButton.click();