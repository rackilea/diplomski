ToolWindow toolWindow = toolWindowManager.registerToolWindow("MyPlugin", myPanel, ToolWindowAnchor.RIGHT);

builder.setClickHandler(new ActionListener() {
    @Override
        public void actionPerformed(ActionEvent e) {
            toolWindow.show(new Runnable() {
                    @Override
                        public void run() {
                            System.out.print("Showing the plugin!");
                        }
                });
        }
}, true);