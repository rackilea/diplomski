public class ActionEventMatcher extends ArgumentMatcher<ActionEvent> {
    /* fields here */

    public ActionEventMatcher(
            Matcher<Object> sourceMatcher,
            Matcher<Integer> idMatcher,
            Matcher<String> actionCommandMatcher) { /* save fields here */ }

    @Override
    public boolean matches(Object argument) {
        if (!(argument instanceof ActionEvent))
            return false;
        ActionEvent e = (ActionEvent)argument;

        return this.sourceMatcher.matches(e.getSource())
            && this.idMatcher.matches(e.getId())
            && this.actionCommandMatcher.matches(e.getActionCommand());
    }
}