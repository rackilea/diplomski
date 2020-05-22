/**
 * @return the Reference
 */
public int getReference() {
    if(Reference > 0){
        replyWith = "Duck";
    }else{
        replyWith = "Fruck";
    }
    EntityManager em;
    Armazem find = em.find(Armazem.class, Reference);
    replyWith = find.getNome();
    return Reference;
}