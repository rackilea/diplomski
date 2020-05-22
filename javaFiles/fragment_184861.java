JTextArea optionsTxtUrl = new JTextArea(1,15);
optionsTxtUrl.setLineWrap(true);
optionsTxtUrl.setWrapStyleWord(true);
JScrollPane scroll = new JScrollPane(optionsTxtUrl);

options.add(scroll); // take out options.add(optionsTxtUrl);