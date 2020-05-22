class Job {
  String title;

  @ManyToOne
  @JoinColumn(name = "location_id")
  @EntityMapper(isRef="true")//Custom Annotation
  JobLocation location;
}

class JobLocation {
  @EntityMapper(fieldName="jobLocationId")
  int id;
  @EntityMapper(fieldName="jobLocationDescription")//Custom Annotation
  String description;
  double latitude;
  double longitude;
}