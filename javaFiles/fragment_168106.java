public class CoinAccessor implements TweenAccessor<Coin> {

    public static final int POS_XY = 1;
    public static final int CPOS_XY = 2;

    @Override
    public int getValues(Coin target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case POS_XY:
                returnValues[0] = target.getX();
                returnValues[1] = target.getY();
                return 2;

            case CPOS_XY:
                returnValues[0] = target.getX() + target.getWidth()/2;
                returnValues[1] = target.getY() + target.getHeight()/2;
                return 2;

            default: assert false; return -1;
        }
    }

    @Override
    public void setValues(Coin target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case POS_XY: target.setPosition(newValues[0], newValues[1]); 
            break;

            case CPOS_XY: target.setPosition(newValues[0] - target.getWidth()/2, newValues[1] - target.getHeight()/2); 
            break;

            default: assert false;
        }
    }
}