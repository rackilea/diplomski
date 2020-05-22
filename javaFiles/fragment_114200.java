public void  playSong(final int naatindex){
// Play song
tv = (TextView) this.findViewById(R.id.mywidget);  
bf = (TextView) this.findViewById(R.id.showbuffering);


try {

mp.reset();
mp.setDataSource(naatpaths[naatindex]);
tv.setVisibility(View.INVISIBLE);
bf.setVisibility(View.VISIBLE);   
mp.prepareAsync();



mp.setOnPreparedListener(new OnPreparedListener(){
@Override
public void onPrepared(MediaPlayer mp){
 bf.setVisibility(View.INVISIBLE);
 tv.setVisibility(View.VISIBLE);
 tv.setSelected(true);
 mp.start();

  tv.setText(naattitles[naatindex]);
        tv.setSelected(true);
        // Changing Button Image to pause image
  btnPlay.setImageResource(R.drawable.btn_pause);
  // set Progress bar values
  songProgressBar.setProgress(o);
  songProgressBar.setMax(100);
  // Updating progress bar
  updateProgressBar(); 




}
  });

      // Set focus to the textview

     } catch (IllegalArgumentException e) {
             e.printStackTrace();
      } catch (IllegalStateException e) {
         e.printStackTrace();
         } catch (IOException e) {
       e.printStackTrace();
     }
  }