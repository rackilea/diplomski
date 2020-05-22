private void loadCommands(String fileName) {
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader(fileName));

        while (br.ready()) {
            actionList.add(CommandFactory.GetCommandFromText(this, br.readLine()));
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) try { br.close(); } catch (IOException logOrIgnore) {}
    }       
}