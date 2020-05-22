DefaultComboBoxModel<Speciality> specialityModel = new DefaultComboBoxModel<Speciality>();
boxSpeciality.setModel( specialityModel );
boxFaculty.addActionListener( new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = boxFaculty.getSelectedItem();
        if ( obj != null )
        { 
           ArrayList<Speciality> specialities = treeMap.get( obj );
           specialityModel.removeAllElements();
           for ( Speciality speciality : specialities )
           {
              specialityModel.addElement( speciality );
           }
        }

    }

});