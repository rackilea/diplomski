// ...initialization of Form and tb2
        TextField tb3 = new TextField("Message: ", "", 256, TextField.ANY);
        // above, TextBox has been replaced with TextField
        form1.append(tb3); // show "Message" textfield above "Mobile"
        form1.append(tb2);
        form1.addCommand(submitCommand);
        display.setCurrent(form1);