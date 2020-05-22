public class Payment {
private String payType;

private CreditCard creditCard;
private BankAccount bankAccount;

@Valid
public Object getValid(){
    if(creditCard!=null && payType.equals("credit"))
        return creditCard;
    if(bankAccount !=null&& payType.equals("bank")){
        return bankAccount;
    }
    return null;
}  
}