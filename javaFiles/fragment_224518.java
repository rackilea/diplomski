for(Command command : commands) {
  if (command instanceof AddCommand || command instanceof UpdateCommand) {
    if (isMaturityDateInPast() || paymentDueDate().isAfter(LocalDate.now())) {
        continue;
    }
  }
  command.execute();
}