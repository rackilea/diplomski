TypedMultimap typedMultimap = new TypedMultimap();
    typedMultimap.putSafely(new ExportThing("prvý"));
    typedMultimap.putSafely(new ExportThing("druhý"));
    typedMultimap.putSafely(ExportThing.class, new ExportThing("prvý"));
    typedMultimap.putSafely(new ExportPhoneNumber("prvý"));
    typedMultimap.putSafely(ExportPhoneNumber.class, new ExportPhoneNumber("druhý"));
    Collection<ExportPhoneNumber> safely = typedMultimap.getSafely(ExportPhoneNumber.class);
    for (ExportPhoneNumber safely1 : safely) {
        System.out.println(safely1.getPhoneNumber());
    }