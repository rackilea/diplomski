public void deleteByAllPatientFlowGens(List<PatientFlowGen> list) {
    if (!list.isEmpty()) {
        list.forEach(patientFlowGen -> {
            getEntityManager().createNamedQuery(DELETE_BY_ALL_PATIENT_FLOW_GENS_QUERY)
                    .setParameter("patient_flow_gens", patientFlowGen)
                    .executeUpdate();
        });
    }
}