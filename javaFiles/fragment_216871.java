try
    {
        out=new BufferedOutputStream(new FileOutputStream(file));
        kit.write(out,
                  contents,
                  contents.getStartPosition().getOffset(),
                  contents.getLength());
        out.close();
    }
    catch(IOException | BadLocationException ex)
    {
         bError=true;
         Logger.getLogger(CFrameMain.class.getName()).log(Level.SEVERE,
                        null,
                        ex);
     }
     finally
     {
          if(bError!=true)
          {
                       currentDocument.setFilename(chooserSaveAs.getSelectedFile().getAbsolutePath());
                      this.toolBarFileSwitcher().listOpenedFiles().model().set(this.toolBarFileSwitcher().listOpenedFiles().getSelectedIndex(),
                            currentDocument.filename());
                    this.toolBarFileSwitcher().updateUI();
           }
    }