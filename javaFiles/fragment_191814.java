Flowable.fromIterable(chat.messages)
    .concatMap { message ->
        repository.getUserById(message.senderId)
            .concatMap { user ->
                Flowable.just(SimpifiedMessage(user.name, message.content))
            }
    }
    .toList()