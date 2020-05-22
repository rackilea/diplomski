for(Point p:iterablePoints)
  {
     int dir = 2; //0:right, 1:down, 2:left, 3:up
     int xPos = p.x;
     int yPos = 0;
     Polygon poly = new Polygon();
     for(int y = p.y; y>0; y--)
     {
        if(capture.getRGB(p.x,y-1)==Color.BLACK.getRGB())
        {
           yPos = y;
           break;
        }
     }
     Vector<Point> tempRecord = new Vector<Point>();
     boolean run = true;
     while(run)
     {               
        if(dir==0&&capture.getRGB(xPos+1,yPos)==Color.BLACK.getRGB())dir--;
        else if(dir==1&&capture.getRGB(xPos,yPos+1)==Color.BLACK.getRGB())dir--;
        else if(dir==2&&capture.getRGB(xPos-1,yPos)==Color.BLACK.getRGB())dir--;
        else if(dir==3&&capture.getRGB(xPos,yPos-1)==Color.BLACK.getRGB())dir--;
        else 
        {
           if(dir==0)xPos++;
           if(dir==1)yPos++;
           if(dir==2)xPos--;
           if(dir==3)yPos--;

           dir++;

           tempRecord.add(new Point(xPos,yPos));
           if(tempRecord.size()>1)if(tempRecord.get(0)==tempRecord.get(1))tempRecord.remove(tempRecord.firstElement());
           else startPoint = tempRecord.get(0);
           if(startPoint!=null)if(startPoint.x==xPos&&startPoint.y==yPos) run=false;
           poly.addPoint(xPos,yPos);capture.setRGB(xPos,yPos,Color.MAGENTA.getRGB());
        }
        if(dir==4)dir=0;
        if(dir==-1)dir=3;
     }
     Graphics cg = capture.getGraphics();
     cg.setColor(Color.MAGENTA);
     cg.fillPolygon(poly);
     cg.dispose();
  }