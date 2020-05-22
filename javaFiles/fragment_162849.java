JFrame f = new JFrame();
    f.setLayout(new BorderLayout());
    //
    JPanel stuffH = new JPanel();
    f.add(stuffH, BorderLayout.CENTER);
    stuffH.setLayout(new BoxLayout(stuffH, BoxLayout.X_AXIS));
    //
    JPanel stuffV = new JPanel();
    stuffV.setLayout(new BoxLayout(stuffV, BoxLayout.Y_AXIS));
    //
    JLabel label = new JLabel("Password");
    BoxAdapter labelAdapter = new BoxAdapter();
    labelAdapter.add(label);
    JPasswordField field = new JPasswordField();
    field.setColumns(10);
    BoxAdapter fieldAdapter = new BoxAdapter();
    fieldAdapter.add(field);
    //
    stuffV.add(new VerticalGlue()); // for vertical spacing
    stuffV.add(labelAdapter);
    stuffV.add(fieldAdapter);
    stuffV.add(new VerticalGlue()); // for vertical spacing
    //
    stuffH.add(new HorizontalGlue()); // for horizontal spacing
    stuffH.add(stuffV);
    stuffH.add(new HorizontalGlue()); // for horizontal spacing
    //
    f.setVisible(true);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);