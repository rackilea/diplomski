public class SomeEventDetails extends BaseEventDetails implements EventDetails {

    private List<MoneyValue> amountCurrencyList;

    @Override
    public void setUpFieldsFromMap() {
        this.amountCurrencyList = super.eventDetails.getAmountCurrencyList();
        if (isNull(amountCurrencyList)) {
            throw new InvalidOrMissingParametersException("Exception during JSON parsing! Critical data is missing in DetailsMap - " + super.eventDetails.toString());
        }
    }
}