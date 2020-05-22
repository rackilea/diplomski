int [] diameters = new int[6];

  for(int i=0;i<diameters.length;i++){
      diameters[i]=console.nextInt();
      for(int j=0;j<30;j+=3){
          g.setColor(new Color(r.nextInt(256),r.nextInt(256), r.nextInt(256)));
          g.fillOval(xCenter-diameters[i]/2-j, yCenter-diameters[i]/2-j, diameters[i]+j, diameters[i]+j);
      }
    }