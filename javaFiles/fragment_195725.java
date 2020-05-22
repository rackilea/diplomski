import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
...

ISharedImages images = (ISharedImages) JavaUI.getSharedImages();
Image image = images.getImage(ISharedImages.IMG_OBJS_CLASS); // class file icon