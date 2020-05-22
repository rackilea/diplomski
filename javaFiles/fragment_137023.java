@Module
public class MyPanelModule {
    static class MyBasePanel extends JPanel {
        private final JLabel myLabel;

        MyBasePanel(JLabel myLabel) {
            this.myLabel = myLabel;
        }

        void initComponents() {
            this.add(myLabel, BorderLayout.CENTER);
        }
    }

    static class MyDerivedPanel extends MyBasePanel {
        private final List<JLabel> addedLabels = new ArrayList<>();

        MyDerivedPanel(JLabel myLabel) {
            super(myLabel);
        }

        @Override
        public void add(Component comp, Object constraints) {
            super.add(comp);
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                addedLabels.add(label);
            }
        }
    }

    @Provides MyBasePanel myBasePanel(@Named("myLabel") JLabel myLabel) {
        MyBasePanel myBasePanel = new MyBasePanel(myLabel);
        myBasePanel.initComponents();
        return myBasePanel;
    }

    @Provides MyDerivedPanel myDerivedPanel(@Named("myLabel") JLabel myLabel) {
        MyDerivedPanel myDerivedPanel = new MyDerivedPanel(myLabel);
        myDerivedPanel.initComponents();
        return myDerivedPanel;
    }

    @Provides @Named("myLabel") JLabel myLabel() {
        return new JLabel("My label");
    }
}