Iterator<TelephoneParameterType> itNTypes = next1.getTelephoneParameterTypes();
while (itNTypes .hasNext()) {

    TelephoneParameterType next = itNTypes .next();
    System.out.println(" - " + next.getType() + " / " + next.getDescription());

}