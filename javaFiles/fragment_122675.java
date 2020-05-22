Set<String> computersWithIssues = Sets.newHashSetWithExpectedSize(technicalIssues.size());
for (TechnicalIssue issue : technicalIssues) {
    computersWithIssues.add(issue.getComputerName());
}
for (Computer computer : computers) {
    computer.setHasTechnicalIssue(computersWithIssues.contains(computer.getComputerName());
}