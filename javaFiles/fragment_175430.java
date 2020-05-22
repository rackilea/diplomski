public class ToolTest {
    public static void main(String[] args) {


        org.antlr.Tool tool = new org.antlr.Tool(new String[] { "GrammarWithErrors.g" });

        final ArrayList<String> messages = new ArrayList<String>();

        ErrorManager.setErrorListener(new ANTLRErrorListener() {

            @Override
            public void warning(Message msg) {
                messages.add("Warning: " + msg.toString());
            }

            @Override
            public void info(String msg) {
                messages.add("Info: " + msg.toString());
            }

            @Override
            public void error(ToolMessage msg) {
                messages.add("Tool Error: " + msg.toString());
            }

            @Override
            public void error(Message msg) {
                messages.add("General Error: " + msg.toString());
            }
        });

        tool.process();

        System.out.println("Done processing...");

        for (String msg : messages) {
            System.out.println(msg);
        }
    }
}