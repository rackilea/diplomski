ParticipantPojo pojo= new ParticipantPojo ();
...
Set<ParticipantIdentificationNumberPojo> identSet = new HashSet<ParticipantIdentificationNumberPojo>();
ParticipantIdentificationNumberPojo identInfo= new ParticipantIdentificationNumberPojo();
identInfo.setType("xyz");
identInfo.setNumber(12345);
identInfo.setParticipantPojo(pojo); // <-- Registering the instance on the owning side.
identSet.add(identInfo);
pojo.setIdentificationNumbers(identSet);