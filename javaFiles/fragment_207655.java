@Override
public void actionPerformed(ActionEvent event) {

    if(event.getSource().equals(reset)){
        buttons.setEnabled(true);
        buttons.setBackground(null);
    }else{
        if(event.getSource()==buttons){
            System.out.println("xxx");
            buttons.setBackground(Color.RED);
            buttons.setEnabled(false);
        }

    }

}