GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates());
List<Update> updates = updatesResponse.updates();
for (Update update : updates) {
    CallbackQuery callbackQuery = update.callbackQuery();
    if (callbackQuery != null)  {
        //use the callbackQuery object peroperties to provide the appropriate response
    }
    //to make the update handler fully functional, make sure to check other types of messages
}