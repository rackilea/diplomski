public class MusicEdit {

    public ArrayList<MusicEdit> getMusiclist() {
        ArrayList<MusicEdit> musiclist = new ArrayList<MusicEdit>();
        code = Integer.parseInt(txtAddMusicCode.getText());
        title = txtAddMusicTitle.getText();
        artist = txtAddMusicArtist.getText();
        price = Integer.parseInt(txtAddMusicprice.getText());
        MusicEdit s = new MusicEdit(code, title, artist, price);
        musiclist.add(s);
            return musiclist;
        }

    }


    public class DisplayMusicCD extends javax.swing.JFrame {
    // Here is to load the TableModel
    String[] columnName = {"Code", "Title", "Artist", "Price"};
    MusicEdit musicEdit =  new MusicEdit ();

    DefaultTableModel dtm = new DefaultTableModel(columnName, 0);
    ArrayList<MusicEdit> musiclist = musicEdit.getMusiclist();    

    public void loadAll(){
    for (Object s : musiclist) {
       dtm.addRow( (Object[]) s);
    }

    tblMusic.setModel(dtm);
}

    public DisplayMusicCD() {   



    initComponents();
    loadAll();
}