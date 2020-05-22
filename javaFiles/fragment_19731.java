List<SymStreamAttributes> listuser3 = symphonyClient.getStreamsClient().getStreams((Integer) 1, (Integer) 10, new SymStreamFilter());

  for (SymStreamAttributes symStream : listuser3) {
        sm = new Stream();
        List<Long> listmembers = (symStream.getSymChatSpecificStreamAttributes() != null) ? symStream.getSymChatSpecificStreamAttributes().getMembers() : null;
        for (Long userId : listmembers) {
            if (userId != localUser.getUserId()) {
                SymUser contact = symphonyClient.getUsersClient().getUserFromId(userId);
                sm.setDisplayName(contact.getDisplayName());
                sm.setId(contact.getId());
                listSendedUser.add(sm);
            }
        }

    }
    return listSendedUser;