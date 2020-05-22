public static String checkValue(PersonalDetails request) {
        if(null == request ) {
            //Throw exception or log/return message as per your need.
        }

        int some_appropriate_size = 50; // You need to decide about some_appropriate_size so that it starts with enough capacity for the full content we are going to append.
        StringBuilder stringBuilder = new StringBuilder(some_appropriate_size);

        stringBuilder.append("Your ");
        if(null!= request.getID() && request.getID().isEmpty())
        {
            stringBuilder.append("ID,");
        }
        if(null!= request.getName() && request.getName().isEmpty())
        {
            stringBuilder.append("Name");
        }
        if(null!= request.getDesignation() &&request.getDesignation().isEmpty())
        {
            stringBuilder.append("Designation");
        }
        if(null!= request.getHomeAddress() && request.getHomeAddress().isEmpty())
        {
            stringBuilder.append("Address");
        }
        stringBuilder.append( "cannot be empty");

        return stringBuilder.toString();
    }