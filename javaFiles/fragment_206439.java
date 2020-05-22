Patient patient = service.getPatient(name);
hospitalEquipment.lock();
try {
  patient.pauseLifeSupport();
  // some code causing an exception
  patient.resumeLifeSupport();
} finally {
  hospitalEquipment.unlock();
}