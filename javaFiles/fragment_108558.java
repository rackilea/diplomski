String payloadFormatJSON =
        "{" +
                "\"registration_ids\" : [\"" + gcmDeviceToken + "\"]," +
                "\"data\" : {" +
                " " + gcmBody + " " +
                "}" +
                "}";