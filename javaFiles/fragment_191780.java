btnCnt = new Container();
btnCnt.setUIID(null);
btnCnt.addComponent(btnBack);
btnCnt.addComponent(btnHome);
btnCnt.addComponent(btnExit);

currentForm.setToolBar(homeToolBar);
currentForm.addCommand(SideLogoCommand);
homeToolBar.addCommandToSideMenu(MenuCommand);
homeToolBar.setTitleComponent(btnLogo);


Container commandCnt = new Container(new BorderLayout());
commandCnt.addComponent(BorderLayout.EAST, btnCnt);
commandCnt.setUIID(null);
Component.setSameHeight(homeToolBar, commandCnt);
stateMachine.findCntHomeV2Header(currentForm).removeAll();
stateMachine.findCntHomeV2Header(currentForm).repaint();
stateMachine.findCntHomeV2Header(currentForm).addComponent(commandCnt);