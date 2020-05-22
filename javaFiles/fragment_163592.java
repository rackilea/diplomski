Point[] points=new Point[3];
int i=0;

public void mousePressed(MouseEvent e){
    if(i==0){
        points[0]=e.getPoint();
    }else if(i==1){
        points[1]=e.getPoint();
    }else if(i==2){
        points[2]=e.getPoint();
    }
    i++;
}