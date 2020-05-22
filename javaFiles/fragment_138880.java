JPanel attachmentPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
Attachment[] attachments=(Attachment[])result.getObject("attachment");
for(Attachment attachment:attachments) {
    Image original=ImageIO.read(new ByteArrayInputStream(attachment.getData()));
    attachmentPanel.add(new JLabel(new ImageIcon(getScaled(original,120,120))));
}
//add the attachmentPanel to your component