String wd = System.getProperty("user.dir");
    this.setAlwaysOnTop(false);
    JFileChooser fc = new JFileChooser(wd);
    fc.setDialogType((int)JFileChooser.OPEN_DIALOG);
    int rc = fc.showDialog(null, "Select Data File to Load");
    this.setAlwaysOnTop(true);

    if (rc == JFileChooser.APPROVE_OPTION)
    {
    File file = fc.getSelectedFile();
    String filename = file.getAbsolutePath();


    ObjectInputStream input = null;
    try{
    input = new ObjectInputStream(new FileInputStream(file));
    this.list1=(ListType1)input.readObject();
    this.list2=(ListType2input.readObject();
    ....
    }catch (IOException x){
      ...  

    }catch(ClassNotFoundException x){
      ...
    }
    }