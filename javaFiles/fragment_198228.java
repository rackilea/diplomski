JInternalFrame selectedFrame = desktopPane.getSelectedFrame();
desktopPane.remove(selectedFrame);
desktopPane.repaint();

secondFrame.updateUI(); // The magic part, less expensive execution.

secondFrame.addInternalFrame(selectedFrame);