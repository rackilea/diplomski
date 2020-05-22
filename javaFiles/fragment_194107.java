ResourceObject myObject = null;
try {
    myObject = getResource();
    processResource(myObject);
} finally {
    if(myObject != null) {
        try {
            myObject.close();
        } catch (Exception e) {
            // Usually there is nothing one can do but log
        }
    }
}