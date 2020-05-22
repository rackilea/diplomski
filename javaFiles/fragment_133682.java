final String request;
    String[] requestArray;
    try {

        request = request().toString();
        requestArray = request.split("\\?", 2);
        String userRequest = requestArray[1];
        System.out.println(userRequest);


        return ok();


    } catch (IndexOutOfBoundsException e) {
        e.printStackTrace(); 
    }


    return ok();