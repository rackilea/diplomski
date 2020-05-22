view.setOnTouchListener(new View.OnTouchListener()
        {

                    @Override
                    public boolean onTouch(View v, MotionEvent e) {
                        GeoPoint geo = null;
                        IProjection project = view.getProjection();
                        geo=(GeoPoint)project.fromPixels((int)e.getX(),(int)e.getY());
                        mainDrawer.addGeopointToMap(point.getName(), point.getDesc(), geo);
                        view.setOnTouchListener(null)
                        return false;
                    }});
        }