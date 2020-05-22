private JsonResponse<List<User>> getUsers(){
    JsonResponse<List<User>> jsonResponse = new JsonResponse<List<User>>();

    // Lets say I have a class called User
    List<User> users = new ArrayList<Users>();
    // get users and add to list

    jsonResponse.setResponseData(users); // No warning on this line
    jsonResponse.setSuccess(true);
    return jsonResponse;
}