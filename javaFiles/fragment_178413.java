Room matchFindRoom= getParentExtension().getParentZone()
                .getRoomByName("MatchFindingRoom");
        getApi().joinRoom(user, getParentExtension().getParentZone().getRoomByName("MatchFindingRoom"));
        List<User> waiterUsers = matchFindRoom.getUserList();
        if(waiterUsers.size() >= 4)
        {
            CreateRoomSettings crs = new CreateRoomSettings();
            crs.setName("testRoom");
            crs.setMaxUsers(4);
            crs.setMaxVariablesAllowed(50);
            crs.setAutoRemoveMode(SFSRoomRemoveMode.WHEN_EMPTY);
            getApi().createRoom(getParentExtension().getParentZone(), crs,
                    null, false, null, false, false);
            Room matchRoom = getParentExtension().getParentZone().getRoomByName("testRoom");
            getApi().joinRoom(waiterUsers.get(0), matchRoom);
            getApi().joinRoom(waiterUsers.get(1), matchRoom);
            getApi().joinRoom(waiterUsers.get(2), matchRoom);
            getApi().joinRoom(waiterUsers.get(3), matchRoom);
            // do other stuff
        }