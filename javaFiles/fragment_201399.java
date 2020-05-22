final Set<ProfileField> connectionFields = EnumSet.of(ProfileField.ID, ProfileField.MAIN_ADDRESS,
                ProfileField.PHONE_NUMBERS, ProfileField.LOCATION,
                ProfileField.LOCATION_COUNTRY, ProfileField.LOCATION_NAME,
                ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE,
                ProfileField.INDUSTRY, ProfileField.CURRENT_STATUS,
                ProfileField.CURRENT_STATUS_TIMESTAMP, ProfileField.API_STANDARD_PROFILE_REQUEST,
                ProfileField.EDUCATIONS, ProfileField.PUBLIC_PROFILE_URL, ProfileField.POSITIONS,
                ProfileField.LOCATION, ProfileField.PICTURE_URL);
        Connections connections = client.getConnectionsForCurrentUser(connectionFields);