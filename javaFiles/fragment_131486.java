@GetMapping(params = "customerId")
public ResponseEntity<List<DailyEntry>> getDailyEntriesFromCustomerId(@RequestParam(value = "customerId") Long customerId) {
  return dailyEntryService.getDailyEntriesFromCustomerId(customerId);
}

@GetMapping(params = "employeeId")
public ResponseEntity<List<DailyEntry>> getDailyEntriesFromEmployeeId(@RequestParam(value = "employeeId")  Long employeeId) {
  return dailyEntryService.getDailyEntriesFromEmployeeId(employeeId);
}