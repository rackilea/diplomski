// Above all if else
    //assuming cmd will be directly your event name. search for event name in eventList if it exists then call findEvent method with eventName( here it will be cmd) as parameter.

    } else if (eventList.contains(cmd)) {
        findEvent(cmd);
    }