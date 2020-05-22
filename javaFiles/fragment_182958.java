@Validated
@FeignClient()
public interface AccountClient {
   @PostMapping("/accounts/account/create")
   void createAccount(@Valid CreateAccountRequest request);

   @Valid
   @PostMapping("/accounts/account/get")
   AccountResponse getAccount(AccountRequest request);

}