data = "start";
int chunk = threadNumber;
while (data != null) {
  requestChunk(chunk);
  chunk += numberOfThreads;
}