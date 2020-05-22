public class TestCustomMediator extends AbstractMediator {

    @Override
    public boolean mediate(MessageContext mc) {

        OMElement mobileElement = mc
            .getEnvelope()
            .getBody()
            .getFirstElement()
            .getFirstChildWithName(
                new QName("http://ws.wso2.org/dataservice", "mobile_no"))

        if (mobileElement != null) {
            String mobileNumber = mobileElement.getText();
            mobileNumber = "000" + mobileNumber;
            System.out.println("mobileNumber===" + mobileNumber);
            mc.getEnvelope()
                .getBody()
                .getFirstElement()
                .getFirstChildWithName(
                    new QName("http://ws.wso2.org/dataservice", "mobile_no"))
                .setText(mobileNumber);

            return true;
        }
        return false;
    }
}