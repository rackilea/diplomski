Message message = new Message("me", "you",
    "Almost any char can occur inside this, even \" or \\. They are simply escaped");
    // The Java language itself uses the same escape sequences as JSON.
    // It actually works the same way

// Surprisingly easy to convert Java object to JSON
new Gson().toJson(message);