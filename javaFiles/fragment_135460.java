try {
    socket.setSoTimeout(30000);

    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    while ((line = bufferedReader.readLine()) != null ) {
        response.append(line);
    }
} catch (SocketTimeoutException ste) {
    // timeout reached
} catch (Exception e) {
    // something else happened
} finally {
    // some general processing
}