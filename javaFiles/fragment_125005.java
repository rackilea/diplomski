String[] projection = { PersonModel.C_FIRST_NAME,
                PersonModel.C_LAST_NAME };
        Cursor cursor = context.getContentResolver().query(
                ContentUris.withAppendedId(
                        AkdemiaProvider.CONTENT_URI_RELATIONSHIP_JOIN_PERSON_GET_RELATED, id), 
                        projection, null, null, null);