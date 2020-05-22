List<String> sharedContacts = contactsList.stream()
            .flatMap(contacts -> Optional.ofNullable(contacts.getSharedFriendsIds())
                    .map(Collection::stream).orElseGet(Stream::empty))
            .sorted().collect(Collectors.toList());

  Where the filtering of null `sharedFriendsIds` are done in such a way that 
 they are absorbed into the `flatMap` logic as empty streams.