channel.editMessageById(messageId, embed).queue(
    (success) -> {
        System.out.printf("[%#s] %s (edited)\n",
                   success.getAuthor(), success.getContentDisplay()); // its a Message
    },
    (failure) -> {
        failure.printStackTrace(); // its a throwable
    }
);