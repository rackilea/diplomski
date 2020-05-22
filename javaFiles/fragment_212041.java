try {
    //call some methods that throw IOException's
} catch (IOException e) {
    // This will catch MalformedURLException since it is an IOException
} catch (MalformedURLExceptionn ex) {
    // Will now never be caught! Ah!
}