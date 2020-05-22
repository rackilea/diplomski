try {
        return myApiService.tellJoke().execute().getData();
    } catch (IOException e) {
        return e.getMessage();
    }
}