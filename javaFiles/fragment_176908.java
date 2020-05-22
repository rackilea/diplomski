public void paint(Graphics g){
            super.paint(g);
            for(int i=0;i<shapeList.size();i++){
                ((Shape)shapeList.get(i)).paint(g);
            }
        }