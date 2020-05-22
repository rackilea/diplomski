package net.unbewaff;

public class DemoTestCase {

    private WicketTester tester = new WicketTester();
    private Panel panel = new MyPanel("panel");

    @Test
    public void testIt() {
        tester.startComponentInPage(panel);
        tester.assertComponent("panel", Panel.class);
        tester.assertComponent("panel:reqs", ListView.class);
        tester.assertComponent("panel:reqs:0", ListItem.class);
        tester.assertLabel("panel:reqs:0:lblreqs", "1");
        tester.assertComponent("panel:reqs:1", ListItem.class);
        tester.assertLabel("panel:reqs:1:lblreqs", "2");
        tester.assertComponent("panel:reqs:2", ListItem.class);
        tester.assertLabel("panel:reqs:2:lblreqs", "3");
        tester.assertComponent("panel:reqs:3", ListItem.class);
        tester.assertLabel("panel:reqs:3:lblreqs", "4");
    }

    private final class MyPanel extends Panel {

        private MyPanel(String id) {
            super(id);
        }

        public void onInitialize() {
            ListView<String> reqs;

            final LigaBaseball lbb = new LigaBaseball();

            reqs = new ListView<String>("reqs", new ListModel<String>(lbb.getRequisitos())) {

                protected void populateItem(ListItem<String> item) {
                    item.add(new Label("lblreqs", (item.getModelObject())));
                }
            };

            add(reqs);

            super.onInitialize();
        }
    }

    class LigaBaseball {

        public List<String> getRequisitos() {
            String[] a = { "1", "2", "3", "4" };
            return Arrays.asList(a);
        }
    }
}