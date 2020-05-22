List<Point> points = new ArrayList<>(); // instance field.

            canvas.addMouseMotionListener(new MouseMotionListener () {                      
            public void mouseDragged (MouseEvent m) {
                Point p = m.getPoint() ;
                if (changer==1){
                g.drawLine(lastPos.x, lastPos.y, p.x, p.y) ;
                points.add(lastPos);// add it here.
                }           
                lastPos = p ;

            }   
            public void mouseMoved (MouseEvent m) {}
        });