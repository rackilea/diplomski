int totalRead = 0;
while ((bytesRead = inStream.read(buffer)) != -1) {
    totalRead += bytesRead;
    file.write(buffer, 0, bytesRead);

    progressBar.setValue((int)(totalRead / (double) totalDownloadSize));
}