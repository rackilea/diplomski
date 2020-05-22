// imports snipped for clarity
public class SessionStateTest() {

    public void testMatchingMembers() {
        assertEquals("wrong number of values", SessionState.values().size(), SessionStateCopy.values().size());
        for (SessionState s: SessionState.values()) {
            assertEquals ("wrong value", s, convert(convert(s));
        }
    }
}