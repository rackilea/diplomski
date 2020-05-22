boolean isYellow = false;
for (int i = 0; i < 3; i++) {
            if ((row == coordinatesYellow[i][0]) && (column == coordinatesYellow[i][1])) {
                c.setBackground(Color.yellow);
                isYellow = true;
            }
        }
if( !isYellow )
  c.setBackground(Color.white);