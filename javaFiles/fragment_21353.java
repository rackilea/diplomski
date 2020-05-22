Random rnd = new Random();
double percent = rnd.getNextDouble()*100;
for (Command c : commands) {
  if (percent < c.getExecutionPercentage()) {
    // we select the current command
    percent = rnd.getNextDouble()*100;
    if (percent < command.getDataCriteria().getPreviousPercentage()) {
      // we select Previous
    } else {
      // we select New
    }
    break;
  } else {
    percent -= c.getExecutionPercentage();
  }
}