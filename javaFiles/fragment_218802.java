Title one = new Title(name, beginn, new LocalDate(1922, 6, 5));
Issue morningIssue = new Issue("Morning issue", true, true, true, true, true, true, false);
morningIssue.setExclusions(geschlossen);
one.addIssue(morningIssue);
one.optimise();

Title two = new Title(name, new LocalDate(1922, 6, 6), nameChange.minusDays(1));
two.addIssue(morningIssue);