@Override public int compareTo(Account aThat) {
final int BEFORE = -1;
final int EQUAL = 0;
final int AFTER = 1;

//this optimization is usually worthwhile, and can
//always be added
if (this == aThat) return EQUAL;

//primitive numbers follow this form
if (this.fAccountNumber < aThat.fAccountNumber) return BEFORE;
if (this.fAccountNumber > aThat.fAccountNumber) return AFTER;

//booleans follow this form
if (!this.fIsNewAccount && aThat.fIsNewAccount) return BEFORE;
if (this.fIsNewAccount && !aThat.fIsNewAccount) return AFTER;

.
.
.
//all comparisons have yielded equality
//verify that compareTo is consistent with equals (optional)
assert this.equals(aThat) : "compareTo inconsistent with equals.";

return EQUAL;
}