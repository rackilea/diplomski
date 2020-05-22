public void deactivateByNotFoundInIncomingClinic(long clinicSystemId)
{
    em.createNamedQuery("Clinic.deactivateByNotFoundInIncomingClinic")
            .setParameter(1, clinicSystemId)
            .getSingleResult();
}