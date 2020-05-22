while((line = bufferedReader.readLine()) != null) {
    String[] parts = line.split("-");

    if (parts.length >= 2 && parts[0].trim().equals(parts[1].trim())) {
        doSomethingHere();
    }
}