try {
    //call some methods that throw IOException's
} catch (MalformedURLExceptionn ex) {
    // This will catch MalformedURLException 
} catch (IOException e) {
    // This will catch IOException and all other subclasses besides MalformedURLException
}