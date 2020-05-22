@Override
@Async("asyncExecutor")
public Future<Merchant> fetchMerchant(String id) {
   ResponseEntity<Merchant> response = 
    restTemplate.getForEntity(url.concat(URL_DELIMITER).concat(id), 
    Merchant.class);
   return CompletableFuture.completedFuture(response.getBody());
}