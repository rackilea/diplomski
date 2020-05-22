Iterator<TelephoneFeature> itNumbers = vcard.getTelephoneNumbers();
while (itNumbers.hasNext()) {

    TelephoneFeature next1 = itNumbers.next();
    String telephone = next1.getTelephone();

    System.out.println(telephone);
    System.out.println("types = " + next1.getExtendedTelephoneParameterSize());

    Iterator<XTelephoneParameterType> itTypes = next1.getExtendedTelephoneParameterTypes();
    while (itTypes.hasNext()) {

        XTelephoneParameterType next = itTypes.next();
        System.out.println(" - " + next.getType() + " / " + next.getDescription());

    }

}