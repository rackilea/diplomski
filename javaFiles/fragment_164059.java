intptr LogException(LPEXCEPTION_POINTERS pep){
    // Log the exception
    return EXCEPTION_CONTINUE_SEARCH;
}

__try{
    // Some code
}
__except(LogException(GetExceptionInformation())){}