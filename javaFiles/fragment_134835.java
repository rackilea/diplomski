Component[] component = contentPane.getComponents();
    for(int i=0; i<component.length; i++){
        component[i].applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        Component[] cp = ((Container) component[i]).getComponents();
        for(int j=0; j<cp.length; j++){
            try{
                ((Component) ((JComboBox) cp[j]).getRenderer()).applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            }catch(Exception e){
                continue;

            }
        }
    }