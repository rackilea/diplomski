try {
    checkStats();
} catch (RiotApiException e) {
    // Handle the exception
    Log.e("NewLayoutActivity", e.getMessage());
}