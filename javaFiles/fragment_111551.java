public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();

                JMenuBar bar = new JMenuBar();
                bar.setLayout(new MigLayout());

                JMenu listSth = new JMenu("A");
                listSth.setHorizontalTextPosition(SwingConstants.CENTER);
                listSth.setVerticalTextPosition(SwingConstants.BOTTOM);
                bar.add(listSth);

                JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
                bar.add(sep1, "growy");
                JMenu module = new JMenu("B");
                module.setHorizontalTextPosition(SwingConstants.CENTER);
                module.setVerticalTextPosition(SwingConstants.BOTTOM);
                bar.add(module);

                JMenu settings = new JMenu("Settings");
                settings.setHorizontalTextPosition(SwingConstants.CENTER);
                settings.setVerticalTextPosition(SwingConstants.BOTTOM);
                bar.add(settings);

                JMenu build = new JMenu("Builder");
                build.setHorizontalTextPosition(SwingConstants.CENTER);
                build.setVerticalTextPosition(SwingConstants.BOTTOM);
                bar.add(build);

                JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);
                bar.add(sep2, "growy");

                JMenu help = new JMenu("Help");
                help.setHorizontalTextPosition(SwingConstants.CENTER);
                help.setVerticalTextPosition(SwingConstants.BOTTOM);
                bar.add(help);

                frame.setJMenuBar(bar);
                frame.pack();
                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}