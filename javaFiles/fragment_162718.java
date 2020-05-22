@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < _animations.size(); i++) {
            if(i==0){
                _auxiliary_image.createGraphics().drawImage(_animations.get(i).getActual().getImage(), 0, 0, Color.white, null);
            }else{
                _auxiliary_image.createGraphics().drawImage(_animations.get(i).getActual().getImage(), 0, 0, null);
            }

        }
        _image2display.setImage(_auxiliary_image);
        _image2display.paintIcon(this, g, 50, -200);
    }