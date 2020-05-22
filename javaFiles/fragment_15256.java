JComponent comp = new JScrollPane(new JTable(20, 1));
    comp.setBorder(new TitledBorder("Some Item"));
    JComponent other = new JScrollPane(new JTable(10, 1));
    other.setBorder(new TitledBorder("Other items"));
    JComponent panel = new JPanel();
    panel.setBorder(new TitledBorder("Stewhatever"));
    JTextArea log = new JTextArea();
    log.setBorder(new TitledBorder("Log"));

    MigLayout layout = new MigLayout("wrap 3, debug"); //, "", "[fill, grow]"); 
    JComponent content = new JPanel(layout);
    String cc = "width 33%, height 65%, grow";
    content.add(comp, cc);
    content.add(other, cc);
    content.add(panel, cc);
    content.add(log, "height 35%, span, grow");