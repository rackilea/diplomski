Timer timer = new Timer();
timer.schedule(new TimerTask() {

@Override
public void run() {   
event.JDA().getPresence().setGame(Game.watching(event.getJDA().getGuilds().size() + "servers"));
}
}, 0, 20000 );