JFileChooser file=new JFileChooser();
          file.showSaveDialog(this);
          File save =file.getSelectedFile();
          if(save !=null){

              sht.fillData(tblCliente, save);

          }
        }catch(Exception ex){
            ex.printStackTrace();
        }