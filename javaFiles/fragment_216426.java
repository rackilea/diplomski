if(value == JFileChooser.APPROVE_OPTION){
         ourSrtFile =  ourFileSelector.getSelectedFile();
         srtPath = ourSrtFile.getAbsolutePath(); //<--transfer it here
          }else if(value == JFileChooser.CANCEL_OPTION){
               JOptionPane.showMessageDialog(null, "you closed with out selecting file");
          }