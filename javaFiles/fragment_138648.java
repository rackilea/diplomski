import lotus.domino.AgentBase;
import lotus.domino.Session;

public class JavaAgent extends AgentBase {

    @Override
    public void NotesMain() {
        try {
            final String xpageName = "demo";

            Session session = getSession();
            dk.fmcgsolutions.XAgent.run(session.getAgentContext(), xpageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}