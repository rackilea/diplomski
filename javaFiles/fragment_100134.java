private void updateMessages(final String sMessage, final String sType)

{
    SwingUtilities.invokeLater( new Runnable() {
        public void run() {
            String sMessageHTML="";
            String sTypeText="";
            if (!sMessage.equals("\r\n")){
                sTypeText = sType+": ";
            }
            sMessageHTML = sMessage.replaceAll("(\r\n|\n)", "<br/>");
            if (!sMessageHTML.equals("<br/>"))
            {
                sMessageHTML =   "<SPAN CLASS="+sType+">"+ sTypeText+sMessageHTML + "</SPAN>";
            }

            msgBuffer=msgBuffer.concat( sMessageHTML);
            editorPane.setText(msgBuffer);
            if ((editorPane.getDocument()).getLength()>1){
                editorPane.setCaretPosition((editorPane.getDocument()).getLength()-1);
            }
        }
    });
}