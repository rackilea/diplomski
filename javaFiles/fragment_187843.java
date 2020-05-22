package library; // <- this one. 

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.ImageIcon;

    public class StretchIcon extends ImageIcon {

      /**
       * Determines whether the aspect ratio of the image is maintained.
       * Set to <code>false</code> to allow th image to distort to fill the component.
       */
      protected boolean proportionate = true;

      /**
       * Creates a <CODE>StretchIcon</CODE> from an array of bytes.
       *
       * @param  imageData an array of pixels in an image format supported by
       *             the AWT Toolkit, such as GIF, JPEG, or (as of 1.3) PNG
       *
       * @see ImageIcon#ImageIcon(byte[])
       */
      public StretchIcon(byte[] imageData) {
        super(imageData);
      }

      /**
       * Creates a <CODE>StretchIcon</CODE> from an array of bytes with the specified behavior.
       *
       * @param  imageData an array of pixels in an image format supported by
       *             the AWT Toolkit, such as GIF, JPEG, or (as of 1.3) PNG
       * @param proportionate <code>true</code> to retain the image's aspect ratio,
       *        <code>false</code> to allow distortion of the image to fill the
       *        component.
       *
       * @see ImageIcon#ImageIcon(byte[])
       */
      public StretchIcon(byte[] imageData, boolean proportionate) {
        super(imageData);
        this.proportionate = proportionate;
      }

    }