CompletableFuture allCompletableFutures = CompletableFuture.allOf(
  employeeCfWithName, employeeCfWithAccountNumber, employeeCfWithSalary);

// Wait for all three to complete.
allCompletableFutures.get();

// Now join all three and combine the results.
EmployeeDTO finalResult = EmployeeDTO.builder()
  .name(new employeeCfWithName.join())
  .accountNumber(new employeeCfWithAccountNumber.join())
  .salary(new employeeCfWithSalary.join())
  .build();