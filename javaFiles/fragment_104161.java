public class TextDocument extends PlainDocument{


    private static final long serialVersionUID = 1L;
    private int maxLength = Integer.MAX_VALUE;

    TextDocument(){}
    TextDocument(int maxlength){this.maxLength=maxlength;}

     public void setMaxLength(int maxLength) {
            if (maxLength < 0)
                throw new IllegalArgumentException("maxLength<0");
            this.maxLength = maxLength;
        }

     public void insertString(int offset, String str, AttributeSet attr)
     throws BadLocationException {
         if (validateLength(offset, str) == false)
                return;

            super.insertString(offset, str, attr);
     }

     private boolean validateLength(int offset, String toAdd) {
            String str_temp;
            //String str_text = "";
            String str1 = "";
            String str2 = "";
            try {
                str1 = getText(0, offset);
                str2 = getText(offset, getLength() - offset);
            } catch (Exception e) {
                e.printStackTrace();
            }

            str_temp = str1 + toAdd + str2;
            if (maxLength < str_temp.length()) {
                beep();
                return false;
            } else
                return true;

        }

        private void beep() {
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
}