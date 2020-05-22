import android.text.TextPaint;
    import android.text.style.ClickableSpan;
    import android.view.View;

      /**
       * SpaceAdjust.java
      * 
      * This is the class that is used to display underline text
       */
    public class SpaceAdjust extends ClickableSpan {

     /** The clicked. */
      String clicked;

     /**
      * Instantiates a new space adjust.
      * 
      * @param string
      *            the string
      */
      public SpaceAdjust(String string) {
        super();
        clicked = string;
       }

      /*
       * (non-Javadoc)
       * 
      * @see android.text.style.ClickableSpan#onClick(android.view.View)
      */
      public void onClick(View tv) {
        // Un used Code .. Implemented Method
      }

    /*
     * (non-Javadoc)
     * 
     * @see
     * android.text.style.ClickableSpan#updateDrawState(android.text.TextPaint)
     */
    public void updateDrawState(TextPaint ds) {
        ds.setUnderlineText(true); // if you don't want to use underline text, just make this as false.
    }
}