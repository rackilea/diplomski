String response = null;
for (int i = 0; i < RETRY_COUNT && response == null; i++){
  try {
    response = doHttpGetRequest(url);
  } catch (IOException e){
    // Possibly log the error here
  }
}
if (response  == null) return null;