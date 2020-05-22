// you can probably came up with a more meaningful name
public static Petition mapEntryToPetition(Map.Entry<String, List<AuditRegister>> entry) {
    Petition petition = new Petition();
    PetitionData data = new PetitionData();
    data.setUUID(entry.getKey());
    petition.setData(data);
    petition.setRegisters(entry.getValue());
   return petition;
}