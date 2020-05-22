// rules being the predicate list
boolean valid = true;
for (Predicate<> rule : rules) {
    valid = valid && rule.test(word);
}
// At the end of this valid will only remain true if all of the rules pass.