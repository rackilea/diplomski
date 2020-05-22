private void DirectoryChooser(){
    DirectoryChooser chooser = new DirectoryChooser();
    chooser.setTitle("Open images folder");
    folder = chooser.showDialog(window);

    //Null directory check
    if(folder == null){
        System.out.println("Null directory");
    }

    //Else make the image array from that folder
    else{
            System.out.println(folder);
            makeImageViewArr(folder);
    }
}