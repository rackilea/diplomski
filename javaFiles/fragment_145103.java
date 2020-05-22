while (true) {
    try {
        SeleniumCommands.waitClickByCss("[id^=removeForm_]");
    } catch (TimeoutException e) {
        break;
    }

    SeleniumCommands.waitClickById(ManageCommands.CONFIRMMODALOKBUTTON);
}