try {
    Field f = object.getClass().getDeclaredField("eStorage"); 
    f.setAccessible(true);
    Object theDataYouWant = f.get(object);
} catch(Exception e) {
    // Handle exception here...
}