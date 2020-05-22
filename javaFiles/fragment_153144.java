public class BrainTreeImplementation {

private static Logger logger = Logger.getLogger(BrainTreeImplementation.class.getName());

// Below are the Braintree sandbox credentials
private static BraintreeGateway gateway = null;
private static String publicKey = "YOUR_PUBLIC_KEY";
private static String privateKey = "YOUR_PRIVATE_KEY";
private static String merchantId= "YOUR_MERCHANT_ID";   

public static void main(String[] args) {
    // Initialize Braintree Connection
    gateway = connectBraintreeGateway();
    braintreeProcessing();
}

public static void braintreeProcessing() {

    System.out.println(" ----- BrainTree Implementation Starts --- ");

    // Generate client Token
    String clientToken = generateClientToken();
    System.out.println(" Client Token : " +clientToken);

    // Receive payment method nonce
    String nonceFromTheClient = receivePaymentMethodNonce();

    // Do payment transactions
    BigDecimal amount = new BigDecimal("5.10");
    doPaymentTransaction(nonceFromTheClient, amount);
}

// Connect to Braintree Gateway.
public static BraintreeGateway connectBraintreeGateway() {
    BraintreeGateway braintreeGateway = new BraintreeGateway(
            Environment.SANDBOX, merchantId, publicKey, privateKey);
    return braintreeGateway;
}

// Make an endpoint which return client token.
public static String generateClientToken() {
    // client token will be generated at server side and return to client
    String clientToken = gateway.clientToken().generate();
    return clientToken;
}

// Make an endpoint which receive payment method nonce from client and do payment.
public static String receivePaymentMethodNonce() {
     String nonceFromTheClient =  "fake-valid-mastercard-nonce";
     return nonceFromTheClient;
}

// Make payment 
public void String doPaymentTransaction(String paymentMethodNonce, BigDecimal amount) {

    TransactionRequest request = new TransactionRequest();
    request.amount(amount);
    request.paymentMethodNonce(paymentMethodNonce);

    CustomerRequest customerRequest = request.customer();
    customerRequest.email("cpatel@gmail.com");
    customerRequest.firstName("Chirag");
    customerRequest.lastName("Patel");

    TransactionOptionsRequest options = request.options();
    options.submitForSettlement(true);

    // Done the transaction request
    options.done();

    // Create transaction ...
    Result<Transaction> result = gateway.transaction().sale(request);
    boolean isSuccess = result.isSuccess();

    if (isSuccess) {
        Transaction transaction = result.getTarget();
        displayTransactionInfo(transaction);
    } else {
        ValidationErrors errors = result.getErrors();
        validationError(errors);
    }
}

private static void displayTransactionInfo(Transaction transaction) {
    System.out.println(" ------ Transaction Info ------ ");
    System.out.println(" Transaction Id  : " +transaction.getId());
    System.out.println(" Processor Response Text : " +transaction.getProcessorResponseText());
}

private static void validationError(ValidationErrors errors) {
    List<ValidationError> error = errors.getAllDeepValidationErrors();
    for (ValidationError er : error) {
        System.out.println(" error code : " + er.getCode());
        System.out.println(" error message  : " + er.getMessage());
    }
}
}