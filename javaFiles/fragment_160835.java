boolean isSet = false;
try {
    req.getPart("file");
    isSet = true;
} catch(Exception e) { 
    isSet = false; 
}

if (isSet) {
    // Do your work
}