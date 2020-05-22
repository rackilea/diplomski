public class HotelRequestReBuilder extends AbstractRequestReBuilder<HotelBookingRequest> {

    public HotelBookingRequest rebuildRequest(HotelBookingRequest request) {
        BillingDetails billingDetails = request.getBillingDetails();
        BillingDetails modifiedBillingDetails = updateCard(billingDetails);
        request.setBillingDetails(modifiedBillingDetails);
        return request;
    }
}