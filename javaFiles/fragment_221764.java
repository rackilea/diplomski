public class MPGui {
        public MPGui() {
                //initialize GUI
        }

        public class ExecuteListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {

                        Executor execu = new Executor(MLA, MPGUI.this);
                        execu.execute();

                }
        }

        public static void main(String[] args) {
                MPGui a = new MPGui();
        }
}