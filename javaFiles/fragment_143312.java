Gson gson = new GsonBuilder().create();
try {
    ApiError mApiError = gson.fromJson(response.errorBody().string(),ApiError.class); 
} catch (IOException e) {
    // handle failure to read error
}