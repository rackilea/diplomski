Value oldValue = imap.get(key)
Value newValue = oldValue;
if (newValue == null) newValue = new Value()
//Either set part1 or part 2 depends on the node
newValue.setPart1(part1)
imap.replace(key, oldValue, newValue)