@Data
@JsonInclude(Include.NON_NULL)
public class AccountVO {

    // Fields omitted

    @JsonCreator
    public static AccountVO factory(
                     @JsonProperty("accountId") String accountId,
                     @JsonProperty("name") String name,
                     @JsonProperty("email") String email,
                     @JsonProperty("phone") String phone,
                     @JsonProperty("frequency") String frequency,
                     @JsonProperty("paymentMethod") PaymentMethodVO paymentMethod) {

        AccountVO account = new AccountVO();
        account.setAccountId(accountId);
        account.setName(name);
        account.setEmail(email);
        account.setPhone(phone);
        account.setFrequency(frequency);
        account.setPaymentMethod(paymentMethod); // Do any other processing here
        return account;
    }