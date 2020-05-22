private int reference;
private String replyWith;

public void referenceOnkeyup() {
    replyWith = em.find(Armazem.class, Reference).getNome();
}

public int getReference() {
    return reference;
}

public void setReference(int reference) {
    this.reference = reference;
}

public String getReplyWith() {
    return replyWith;
}