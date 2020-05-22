for (Object result : results) {
    if (result instanceof Exception)
        System.out.println("Error: " + result);
    else
        System.out.println("Parsed as " + result.getClass().getSimpleName() + ": " + result);
}