final JavaPlugin Inst = ... //This plugin's object

try(BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")))){
    while((Line = Reader.readLine()) != null){
        final String L = Line;
        Bukkit.getScheduler().runTask(Inst, new Runnable(){
            @Override
            public void run() {
                 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), L);
            }
        });
    }
}catch(IOException ex){
    //Handle this
}