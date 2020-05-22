//Iterate through the HashMap
for(Entry<?, ?> configEntry : pluginConf.entrySet()){
    //Get a string from the selected key that contains only lower-case letters and periods
    String entryKey = configEntry.getKey().toString().replaceAll("[^a-zA-Z.]", "").toLowerCase();

    //Search for join messages
    if(entryKey.equals("messages.join")){
        //Get the key name of the current entry
        String joinKeyName = configEntry.getKey().toString();

        //Create a join message object
        JoinMessage newJoinMessage = new JoinMessage(,
            configData.getString(joinKeyName + ".message")
        );

        //Add the join message object to the join message ArrayList
        joinMessages.add(newJoinMessage);

        //Add to the join message quantity
        joinMsgQuantity ++;
    }
}