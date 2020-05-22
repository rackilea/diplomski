public class saveGame {

    BufferedWriter bw;

    public void save(Player p) {
        try {   
            bw = new BufferedWriter(new FileWriter("saves/saveTest.txt"));   

            //add save things
            bw.write("X: " + p.X);
            bw.newLine();
            bw.write("Y: " + p.Y);
            bw.close();

        } catch (IOException e) {e.printStackTrace();}
    }
}