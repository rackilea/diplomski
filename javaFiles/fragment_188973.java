LabelField importanceLabel = new LabelField("Importance: ",LabelField.FIELD_VCENTER | LabelField.FIELD_RIGHT) {
          public void paint(Graphics g) { 
              g.setColor(0x145085); 
              super.paint(g); 
          } 
          protected void layout(int width, int height) {
              super.layout(Math.min(width, this.getFont().getAdvance(this.getText())), 26); //height of the bitmap);
              setExtent(Math.min(width, this.getFont().getAdvance(this.getText())), 26); //height of the bitmap);
          }
      };