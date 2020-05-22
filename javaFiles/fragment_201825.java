public void moves(){

    for (int i = 0; i<=7;i++){
     for ( int j=0 ; j <= 7 ; j++){
         final int k = i;
         final int l = j;
       labels[i][j].addMouseListener(new MouseAdapter() {

           @Override 
            public void mouseEntered(MouseEvent ee) {
                   labels[k][l].setBorder(border);
                   System.out.println("the case holding the "+e.cases[k][l].getPiece().getType());
            }       });
     }
}
}