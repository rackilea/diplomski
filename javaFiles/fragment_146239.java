if(checkForCurseWords(username))
    return "login not allowed";

try {  // We can also omit the try-catch and let the exception bubble upwards
    createLogin(username);
} catch(DuplicateException e) {
    return "login exists";
} catch(Exception e) {
    return "problem with login";
}
return "main page";