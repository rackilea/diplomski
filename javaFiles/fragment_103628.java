public static void main(String[] args) throws JAXBException {
            final JAXBContext context = JAXBContext.newInstance(PayTypeList.class);
            final Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            final PayTypeList paymentType = new PayTypeList();

            List<String> paymentTypes = new ArrayList<String>();
            paymentTypes.add("one");
            paymentTypes.add("two");
            paymentTypes.add("three");
            paymentType.setPayType(paymentTypes);

            m.marshal(paymentType, System.out);
        }