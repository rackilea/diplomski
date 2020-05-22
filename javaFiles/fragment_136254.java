try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
    AtomicBoolean hasError = new AtomicBoolean();
    AtomicBoolean hasInsufficentPermission = new AtomicBoolean();
    reader.lines().map(String::toLowerCase).forEach(line-> {
        if(line.contains("error code: 2568")) hasError.set(true);
        if(line.contains("insufficient client permissions")) hasInsufficentPermission.set(true);
    });
    if (hasError.get() && hasInsufficentPermission.get()) {
        System.out.println("WebContentStr contains both strings");
    } else {
        System.out.println("Strings not found");
    }
}