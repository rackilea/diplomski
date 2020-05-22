@Override
public void savehl7Address(HL7Address addr) {
    HL7GeneralCode code = addr.use();
    if(code != null && code.getId()==null){
    //HL7GeneralCode is not persistent. We don't support that
        throw new IllegalStateException("Cannot persist an adress using a non persistent HL7GeneralCode");
       //In case you'd want to support it
       //code = em.find(HL7GeneralCode, code.getId());
    }
    //Merge the code without any address info        
    //This will ensure we only reattach the code without triggering the address 
    //transitive persistence by reachability
    addr.setUse(null);
    code.getAddresses().remove(addr);
    code = em.merge(code); 

    //Now set the code to the address and vice-versa  
    addr.setUse(code);
    code.getAddresses().add(addr);

    if ((Integer)addr.getId() == null) {
        System.out.println("[[[[[[[[[[[[ about to persist address ]]]]]]]]]]]]]]]]]]]]");
        em.persist(addr);
    }
    else {
        System.out.println("]]]]]]]]]]]]]]]]]] about to merge address [[[[[[[[[[[[[[[[[[[[[");
        addr = em.merge(addr);
    }       
}