Button[][] playButtons = null;
        Class id=R.id.class;
         Field field = null;
         for(int i = 0; i<9; i++){ 
              for(int k = 0; k<9; k++){ 
                  try {
                    field = id.getField("button"+i+""+k);

                playButtons[i][k] = (Button) findViewById(field.getInt(null));
                } catch (NoSuchFieldException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


              }}