public void actionPerformed(ActionEvent event) {    
   if (event.getSource() == newProj || event.getSource() == newFlick) {    
      if (nameProj != null) {
      }    
      if (option == JFileChooser.APPROVE_OPTION) {            
      } else if (event.getSource() == loadProj || event.getSource() == loadFlick) {    
         if (option == JFileChooser.APPROVE_OPTION) {        
            if (config.exists()) {        
            } else {    
            }    
         }    
      }    
   }
}