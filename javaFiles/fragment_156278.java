@Override
public boolean onTouch(View v, MotionEvent event) {
    Log.d("OnTouch","x:"+event.getX()+"Y:"+event.getY());
    synchronized (getHolder()){
        for (int i=0 ;i<balloons.size();i++){
            balloons.remove(0);
            break;
        }
    }
    return true;
}