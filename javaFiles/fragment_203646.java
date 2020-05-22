try {
    p = builder.start();
    input = new BufferedReader(new InputStreamReader(p.getInputStream()));
    output = new PrintWriter(p.getOutputStream());
} catch (IOException e) {
    Logger.logError(e);
    return;
}