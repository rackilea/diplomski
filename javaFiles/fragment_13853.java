public void actionPerformed(ActionEvent evt) {

   //HERE next and pre are Button name;
   //rs is REsultSet
  if (evt.getSource()==next) 
    {

        try {

            if (rs.next()) 
            {
                if(rs.isLast())
                { 
                    pre.setEnabled(true);
                    next.setEnabled(false);
                }
                //do action

            }





        } catch (SQLException ex) {
            Logger.getLogger(DeleteQ.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 

    else if (evt.getSource() == pre)
    {

       try {


           if(rs.previous())
            {
                if(rs.isFirst())
                {
                    pre.setEnabled(false);
                    next.setEnabled(true);
                }
               //do action


            }




        } catch (SQLException ex) 
        {
            Logger.getLogger(DeleteQ.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}