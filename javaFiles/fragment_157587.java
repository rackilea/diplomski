@Data
@JsonInclude(Include.NON_NULL)
public class AccountVO {

    // Fields omitted

    public AccountVO(@JsonProperty("accountId") String accountId,
                     @JsonProperty("name") String name,
                     @JsonProperty("email") String email,
                     @JsonProperty("phone") String phone,
                     @JsonProperty("frequency") String frequency,
                     @JsonProperty("paymentMethod") PaymentMethodVO paymentMethod) {

        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.frequency = frequency;
        this.paymentMethod = paymentMethod; // Do any other processing here
    }
}