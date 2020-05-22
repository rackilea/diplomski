resource = null;
try {
   resource = ...;
}  finally {
    if (resource != null) {
        resource.close();
    }
}