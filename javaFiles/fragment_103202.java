while(!s.empty()){
    // We know we have one element available; store it in "top"
    Integer top = s.pop();
    // If the next element is not available, exit 
    if (s.empty()) {
        break;
    }
    if(top < s.peek()){
        // Once result is set to "false", it never becomes "true"
        // so we might as well return now:
        return false;
    }
}
return true;