private boolean isRecaptchaValid(String recaptchaKey, String useRecaptcha) {
    String recaptchaSecretKey = configuration.getString("recaptchaSecretKey");

    WSRequest holder = ws.url("https://www.google.com/recaptcha/api/siteverify");
    holder.setQueryParameter("secret", recaptchaSecretKey);
    holder.setQueryParameter("response", recaptchaKey);

    CompletionStage<JsonNode> jsonPromise = holder.post("").thenApply(WSResponse::asJson);

    JsonNode googleResponse = null;
    try{
        googleResponse = jsonPromise.toCompletableFuture().get(1000, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e){
        e.printStackTrace();
    } catch (ExecutionException e){
        e.printStackTrace();
    } catch (TimeoutException e){
        e.printStackTrace();
    }

    if (googleResponse!= null && googleResponse.get("success") != null && googleResponse.get("success").asBoolean()) {
        return true;
    }

    return false;
}