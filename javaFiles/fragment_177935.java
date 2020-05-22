//Above all if else
    //split the input as find saparate and other remaining string as eventName
    } else if (cmd.startsWith("find")) {
        String eventName = cmd.substring(4, cmd.length());
        findEvent(eventName);
    }