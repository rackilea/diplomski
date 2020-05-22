protected JButton createButton( JPanel panel, String text, 
                                String position, ActionListener listener ) {
   JButton b = new JButton(text);
   panel.add( b, position );
   if ( listener != null ) {
      b.addActionListener(listener);
   }
   return b;
}