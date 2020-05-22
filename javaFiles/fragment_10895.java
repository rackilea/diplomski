final PaintListener paint = new PaintListener() {

            @Override
            public void paintControl(PaintEvent e) {
                int radius = 100;
                int maxX = radius ;
                int maxY = radius ;                             
                int centerX = e.width/2;
                int centerY = e.height/2;
                Image image = new Image(Display.getDefault(),e.width,e.height);
                GC gc = new GC(image);                              
                gc.setAntialias(SWT.ON);
                gc.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
                //gc.drawLine(0, centerY, shell.getBounds().width, centerY);
                //gc.drawLine(centerX, 0, centerX, shell.getBounds().height);
                // 1st circle
                gc.drawOval(centerX-radius/2, centerY-radius - radius/2, maxX, maxY);
                // 2nd circle
                gc.drawOval(centerX - 2*radius + radius/2, centerY - radius/2, maxX, maxY);
                // 3rd circle
                gc.drawOval(centerX+radius/2, centerY-radius/2, maxX, maxY);
                // 4th circle
                gc.drawOval(centerX-radius/2, centerY + radius/2, maxX, maxY);
                direction++;
                direction %= 4;
                switch(direction){                              
                case 0:                 
                    gc.setAlpha(255);
                    gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
                    gc.fillOval(centerX - 2*radius + radius/2, centerY - radius/2, maxX, maxY);
                    break;
                case 1:
                    gc.setAlpha(170);
                    gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
                    gc.fillOval(centerX-radius/2, centerY-radius - radius/2, maxX, maxY);
                    break;                              
                case 2:             
                    gc.setAlpha(80);
                    gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
                    gc.fillOval(centerX+radius/2, centerY-radius/2, maxX, maxY);
                    break;      
                case 3 :            
                    gc.setAlpha(20);
                    gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
                    gc.fillOval(centerX-radius/2, centerY + radius/2, maxX, maxY);
                    break;
                }
                e.gc.drawImage(image, 0, 0);
                image.dispose();
                gc.dispose();
            }
        };