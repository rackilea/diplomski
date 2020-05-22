FirebaseListOptions<ChatMessage> options =
            new FirebaseListOptions.Builder<ChatMessage>()
                    .setQuery(query, ChatMessage.class)
                     .setLayout(android.R.layout.simple_list_item_1)
                    .build();
 adapter = new FirebaseListAdapter<ChatMessage>(options){