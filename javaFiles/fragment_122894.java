public static void main(String[] args) throws Exception {
    JAXBContext context = JAXBContext.newInstance(Transaction.class);
    Unmarshaller um = context.createUnmarshaller();
    Transaction transaction = (Transaction) um.unmarshal(new FileReader(FILE));
    System.out.println(transaction);
}