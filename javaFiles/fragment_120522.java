MyInternalFrame selectedFrame = (MyInternalFrame) desktop.getSelectedFrame();
selectedFrame.getImage();
title = selectedFrame.getTitle();
Info b =new Info(selectedFrame.getImage().duplicate(), selectedFrame.getImage().getTitle(), desktop, save, fft);
ActionEvent s = null;
b.actionPerformed(s);