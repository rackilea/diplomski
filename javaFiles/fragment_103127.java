try {
    obj = myService.findObj(objId)
} 
catch (ObjectNotFoundException) {
    // ignore, obj stays null
}

if (obj == null) {
    // The object wasn't found, it's the "normal" path
} 
else {
    // The object already exist, logs are written and some queue is filled
    // with current objId to be processed later on
}