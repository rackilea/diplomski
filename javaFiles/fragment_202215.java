public final class PatientSearchResultCMRefactor {

private float score;

private String id;
private String firstName;
private String lastName;
private String setupDate;

private AddressCM address;
private Boolean active;
private String dateOfBirth;
private String email;
private String patientExternalId;
private String patientReference;
private String phoneNumber;
private String currentAverageDaysUsed;
private Double currentAverageHoursUsed;

private PatientOrganizationCM organization;
private PatientOrganizationCM topOrganization;

private Set<PatientClinicianCM> clinicians;

private Set<PatientLocationCMRefactor> locations;

private Set<PatientDeviceCM> devices;

private String matchesBy;
//getters, setters, etceterrers
}