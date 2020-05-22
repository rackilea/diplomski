boolean success = false;
try {
    // Stuff here
    success = true;
} finally {
    if (!success) {
        clean();
    }
}