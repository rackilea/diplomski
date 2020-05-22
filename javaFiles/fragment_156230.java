@PostPersist
public void postPersist() {
    for (Envois e : envoisSet) {
        e.getEnvoisPK().setIdmail(this.getIdmail());
    }

}