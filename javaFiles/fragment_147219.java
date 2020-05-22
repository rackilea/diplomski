int pointers = ev.getPointerCount();

    if(pointers == 2) {

        zoom = true;
        s.onTouchEvent(ev);//pass original motionevent(unscaled) to zoom

    }