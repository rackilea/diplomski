JInternalFrame iframe = new JInternalFrame("blah",true,true,true,true);
UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(new Color(248,250,175)));
UIManager.put("InternalFrame.inactiveTitleBackground", new ColorUIResource(new Color(248,250,175)));
javax.swing.plaf.basic.BasicInternalFrameUI ui = 
    new javax.swing.plaf.basic.BasicInternalFrameUI(iframe); 
iframe.setUI(ui);