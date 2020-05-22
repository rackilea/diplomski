public class MyFactory {

    private MyFactory(){
        //hidden constructor
    }

    public static ImageFilter getInstance(String filterType){
        if(filterType == “foo“){
            return new FooFilter();
        }
        return null;
    }
}

public abstract class ImageFilter {
    public abstract <T extends Bitmap> T filterImage(byte[] data, Class<T> clazz);

    //some other stuff
}

public class FooFilter extends ImageFilter {
    public <T extends Bitmap> T filterImage(byte[] data, Class<T> clazz){
        if (BitmapType1.class.isAssignableFrom(clazz)) {
            return this.filterImageA(data);
        } else if (BitmapType2.class.isAssignableFrom(clazz)) {
            return this.filterImageB(data);
        }
        return null; // or better throw runtime exception
    }

    private BitmapType1 filterImageA(byte[] data){
        //
    }

    private BitmapType2 filterImageB(byte[] data){
       //
    }
}

void main(byte[] data) {
    ImageFilter bar = MyFactory.getInstance(“foo“);
    BitmapType1 myBitmap = bar.filterImage(byte[] data, BitmapType1.class);
    BitmapType2 myBitmap2 = bar.filterImage(byte[] data, BitmapType2.class);
}