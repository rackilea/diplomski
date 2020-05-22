for(String id : ids()) {
    try {
        addResult(result(id));
    } catch(ApiException e) {
        System.err.println("Oops, something went wrong for ID "+id+"! Here's the stack trace:");
        e.printStackTrace();
    }
}