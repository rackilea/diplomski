for (int j = 0; j < 10; j++) {
    filearray[j] = br.readLine();
    counter++;
}

for (int i = 1; i < counter; i++) {
    outStream = new PrintWriter(client.getOutputStream(), true);
    outStream.println(filearray[i]);
}