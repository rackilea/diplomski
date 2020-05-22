public class Example {

    static public void main( String[] s ) throws Exception {
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.getContentPane().setLayout( new BorderLayout() );
                frame.setBounds( 50, 50, 600, 600 );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

                JTabbedPane pane = new JTabbedPane();
                pane.addTab( "Lorem", new JLabel("Lorem") );
                pane.addTab( "Ipsum", new JLabel("Ipsum") );
                pane.addTab( "Dolor", new JLabel("Dolor") );
                pane.addTab( "Sit", new JLabel("Sit") );
                pane.addTab( "Amet", new JLabel("Amet") );

                UIDefaults dialogTheme = new UIDefaults();
                dialogTheme.put("TabbedPane:TabbedPaneTab[Enabled].backgroundPainter", new Painter(Painter.BACKGROUND_ENABLED));
                dialogTheme.put("TabbedPane:TabbedPaneTab[Disabled].backgroundPainter", new Painter(Painter.BACKGROUND_DISABLED));
                dialogTheme.put("TabbedPane:TabbedPaneTab[Enabled+MouseOver].backgroundPainter", new Painter(Painter.BACKGROUND_ENABLED_MOUSEOVER));
                dialogTheme.put("TabbedPane:TabbedPaneTab[Enabled+Pressed].backgroundPainter", new Painter(Painter.BACKGROUND_ENABLED_PRESSED));
                dialogTheme.put("TabbedPane:TabbedPaneTab[Selected].backgroundPainter", new Painter(Painter.BACKGROUND_SELECTED));
                dialogTheme.put("TabbedPane:TabbedPaneTab[Disabled+Selected].backgroundPainter", new Painter(Painter.BACKGROUND_SELECTED_DISABLED));
                dialogTheme.put("TabbedPane:TabbedPaneTab[Focused+Selected].backgroundPainter", new Painter(Painter.BACKGROUND_SELECTED_FOCUSED));
                dialogTheme.put("TabbedPane:TabbedPaneTab[MouseOver+Selected].backgroundPainter", new Painter(Painter.BACKGROUND_SELECTED_MOUSEOVER));
                dialogTheme.put("TabbedPane:TabbedPaneTab[Focused+MouseOver+Selected].backgroundPainter", new Painter(Painter.BACKGROUND_SELECTED_MOUSEOVER_FOCUSED));
                dialogTheme.put("TabbedPane:TabbedPaneTab[Pressed+Selected].backgroundPainter", new Painter(Painter.BACKGROUND_SELECTED_PRESSED));
                dialogTheme.put("TabbedPane:TabbedPaneTab[Focused+Pressed+Selected].backgroundPainter", new Painter(Painter.BACKGROUND_SELECTED_PRESSED_FOCUSED));
                dialogTheme.put("TabbedPane:TabbedPaneTabArea[Disabled].backgroundPainter", new AreaPainter(AreaPainter.BACKGROUND_DISABLED));
                dialogTheme.put("TabbedPane:TabbedPaneTabArea[Enabled+MouseOver].backgroundPainter", new AreaPainter(AreaPainter.BACKGROUND_ENABLED_MOUSEOVER));
                dialogTheme.put("TabbedPane:TabbedPaneTabArea[Enabled+Pressed].backgroundPainter", new AreaPainter(AreaPainter.BACKGROUND_ENABLED_PRESSED));
                dialogTheme.put("TabbedPane:TabbedPaneTabArea[Enabled].backgroundPainter", new AreaPainter(AreaPainter.BACKGROUND_ENABLED));
                pane.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                pane.putClientProperty("Nimbus.Overrides", dialogTheme);

                JTabbedPane secondPane = new JTabbedPane();
                secondPane.addTab( "Lorem", new JLabel("Lorem") );
                secondPane.addTab( "Ipsum", new JLabel("Ipsum") );
                secondPane.addTab( "Dolor", new JLabel("Dolor") );
                secondPane.addTab( "Sit", new JLabel("Sit") );
                secondPane.addTab( "Amet", new JLabel("Amet") );

                frame.getContentPane().setLayout( new BorderLayout() );
                frame.getContentPane().add( pane, BorderLayout.NORTH );
                frame.getContentPane().add( secondPane, BorderLayout.CENTER );
                frame.setVisible( true );
            }
        });
    }
}