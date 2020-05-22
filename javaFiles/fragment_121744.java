JPanel buttons = new JPanel();
buttons.add(button1);
...

JPanel footer = new JPanel( new BorderLayout() );
footer.add(label, BorderLayout.CENTER);
footer.add(buttons, BorderLayout.LINE_END);

frame.add(footer, BorderLayout.PAGE_END);