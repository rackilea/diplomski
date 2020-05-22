String wd = System.getProperty("user.dir");
    this.setAlwaysOnTop(false);
    JFileChooser fc = new JFileChooser(wd);

    fc.setDialogType((int)JFileChooser.SAVE_DIALOG);


    int rc = fc.showDialog(null, "Select Data File");
    this.setAlwaysOnTop(true);

    if (rc == JFileChooser.APPROVE_OPTION)
    {
    File file = fc.getSelectedFile();

    ObjectOutputStream output = null;

    try{
    output = new ObjectOutputStream(new FileOutputStream(file));
    output.writeObject(list1);
    output.writeObject(list2);
    output.writeObject(list3);
    ....


    output.close();

    }catch (IOException x){
     ....
    }catch(NullPointerException n){
     ....    
    }}