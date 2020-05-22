public class ButtonService{

    private String mNameButton;
    private int mHeight;
    private int mWidth;
    private int mXBeginPoint;
    private int mYBeginPoint;

    private Button mButton;
    private Activity mContext;


 public ButtonService(String aNameButton, int aHeight, int aWdith, int aXBeginPoint, int aYBeginPoint, Activity aContext)
    {
        mNameButton = aNameButton;
        mHeight = aHeight;
        mWidth = aWdith;
        mXBeginPoint = aXBeginPoint;
        mYBeginPoint = aYBeginPoint;
        mContext = aContext;
    }

public void makeButton()
    {
        mButton = new Button(mContext);
        mButton.setText(mNameButton);
        mContext.setContentView(mButton);
    }
}