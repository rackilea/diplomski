File file = null;

try {
    // ... 
    file = new File(...);
    // ... 
} catch (Exception e) {
    out.println("...");
}

try {
    if (file.isFile())
        // ...
    } else {
        // ...
    }
} catch (Exception e) {
    out.println("...");
}