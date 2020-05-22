for (int i = 0; i < settingsMessages.length; i++) {
    response = ui.getYesNoResponse(settingsMessages[i]);
    if (response.equals("y"))
        settings[i] = true;
    else if (response.equals("n"))
        settings[i] = false;

       autoTakeStepMode = settings[i];

}