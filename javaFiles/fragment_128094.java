int count = 0;
int maxTries = 3;
while(true) {
    try {
        // Some Code
        // break out of loop, or return, on success
    } catch (SomeException e) {
        // handle exception
        if (++count == maxTries) throw e;
    }
}