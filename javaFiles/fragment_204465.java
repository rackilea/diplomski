JButton save = new JButton( "Save" );
save.addActionListener( new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    }
        UserObject user = new UserObject();
        user.setName( nameTextField.getText() );
        user.setAddress( addressTextField.getText() );
        ...
    }
});