@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionHistoryBO { ... }

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionHistoryResponse { ... }

public class App {

    public static void main(String... args) throws JsonProcessingException {

        ObjectMapper om = new ObjectMapper();

        TransactionHistoryResponse thr = new TransactionHistoryResponse();
        TransactionHistoryBO thbo = new TransactionHistoryBO();
        thbo.setProductName("TEST");
        thr.setTransactions(new ArrayList<TransactionHistoryBO>());
        thr.getTransactions().add(thbo);
        System.out.print(om.writerWithDefaultPrettyPrinter().writeValueAsString(thr));
    }

}