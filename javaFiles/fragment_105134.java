view.setOnDragListener( new View.OnDragListener() {
                PointF DownPT = new PointF();
                PointF StartPT = new PointF();
                @Override public boolean onDrag(View v, android.view.DragEvent event) {
                    int dragEvent = event.getAction();
                    switch (dragEvent) {
                        case android.view.DragEvent.ACTION_DRAG_STARTED :
                        DownPT.x = event.getX();
                        DownPT.y = event.getY();
                        StartPT = new PointF( view.getX(), view.getY() ); break;

                        case android.view.DragEvent.ACTION_DRAG_LOCATION :
                        PointF mv = new PointF( event.getX() - DownPT.x, event.getY() - DownPT.y);
                        view.setX((int)(StartPT.x+mv.x)); view.setY((int)(StartPT.y+mv.y));
                        StartPT = new PointF( view.getX(), view.getY() ); break;

                        case android.view.DragEvent.ACTION_DRAG_ENTERED :

                        case android.view.DragEvent.ACTION_DRAG_EXITED :
                        break;
                        case android.view.DragEvent.ACTION_DROP : break;
                        default : break;
                    }
                    return true;
                }
            });