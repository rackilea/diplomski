BufferedReader reader = new BufferedReader(new InputStreamReader(new
BufferedInputStream(thread_cnn.getInputStream())));        
        StringBuilder result = new StringBuilder();
        for (String line = null; (line = reader.readLine()) != null;) {
    result.append(line);
}
println(result);
reader.close();