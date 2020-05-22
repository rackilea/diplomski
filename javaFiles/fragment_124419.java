JPanel buttonPanel = new JPanel(); //panel for buttons.
buttonPanel.add(button1);
buttonPanel.add(button2);
buttonPanel.add(button3);

JScrollPane scroll = new JScrollPane(music); //scrollable pane for JTextArea

panel.add(buttonPanel);
panel.add(scroll); //add sub-components to panel for tab

/*here you would add some layout code to fit the panel and scroll into the associated spaces */

tab.add("Music Files", panel); //add panel to tab