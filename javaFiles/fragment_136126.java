Listners(AudioManager audioManager){
 this.myAudMan = audioManager;
 }
public void vibrate() {
    myAudMan.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
   }
}