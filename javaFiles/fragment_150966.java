HL7GeneralCode code = em.find(HL7GeneralCode, pk);
HL7Address addr = new HL7Address();
if(code != null) {
   code = new HL7GeneralCode();
   em.persist(code);    
}
code.getAddresses().add(addr);
addr.setUse(code);            
em.persist(addr);