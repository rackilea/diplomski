BufferedReader reader = null;
StringBuilder builder = new StringBuilder();

try {
    reader = new BufferedReader(new InputStreamReader(response, charset));
    for (String line; (line = reader.readLine()) != null;) {
        builder.append(line);
    }
} finally {
    if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
}

return builder.toString();