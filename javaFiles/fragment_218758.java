import com.google.gwt.resources.client.ImageResource;

class MyImageResource implements ImageResource {

    public static final MyImageResource INSTANCE = new MyImageResource();

    @Override public int getHeight() {

        return 0;
    }

    @Override public int getLeft() {

        return 0;
    }

    @Override public String getName() {

        return "";
    }

    @Override public int getTop() {

        return 0;
    }

    @Override public String getURL() {

        return "";
    }

    @Override public int getWidth() {

        return 0;
    }

    @Override public boolean isAnimated() {

        return false;
    }
}