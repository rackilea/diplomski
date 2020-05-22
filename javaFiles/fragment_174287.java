JFrame frame = new JFrame();
JDialog dialog = new JDialog(frame);//frame is owner

JFrame parentOfDialog = (JFrame)(dialog.getParent());
//OR
//JFrame parentOfDialog = (JFrame)(dialog.getOwner());
parentOfDialog.removeAll();