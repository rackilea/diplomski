// interface definition
public interface OnColorSelectedListener {
    public void onColorSelected(int color);
}

// in your Fragment
private void sendColor(int color) {
    OnColorSelectedListener listener = (OnColorSelectedListener) getActivity();
    listener.onColorSelected(color);
}

// your Activity
public class PaintingActivity implements OnColorSelectedListener {

    ...

    @Override
    public void onColorSelected(int color) {
        myPaintbrushColor = color;
    }
}