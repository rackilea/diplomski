private LocalDate lastCheck = null;

public boolean isNewDay() {
  LocalDate today = LocalDate.now();
  boolean ret = lastCheck == null || today.isAfter(lastCheck);
  lastCheck = today;
  return ret;
}