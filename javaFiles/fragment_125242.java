// You create a instance of some handler (presumably a implementation of ActionListener)
// which suggests that the handler is not (at least) an anonymous inner class...
theHandler handler = new theHandler();//builds an action listener object
enter.addActionListener(handler)
loginPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
setPanel.add(loginPanel, "LoginScreen");