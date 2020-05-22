public void paintComponent(Graphics g) {
  super.paintComponent(g)

      for(int k = 0; k <= 4; k++){
            for(int j = 0; j <= 3; j++){
                if(field[j][k]==null)continue;
                stein=field[j][k];
                 g.setColor(stein.farbe);
                g.fillRect((field[j][k].sX * PANELSIZE) , (field[j][k].sY * PANELSIZE) , ((((field[j][k].eX-field[j][k].sX) + 1) * PANELSIZE) -1),  ((((field[j][k].eY-field[j][k].sY)+ 1) * PANELSIZE) -1));
            }

        }
}