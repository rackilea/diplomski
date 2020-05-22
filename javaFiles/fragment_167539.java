catch (HttpException ex) {
    // Something went wrong server-side
    int statusCode = ex.getStatusCode();
    String debugId = ex.getHeaders().header("PayPal-Debug-Id");
} catch (Exception e) {
    // Handle accordingly
}