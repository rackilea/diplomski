@Override
public void onTick(long l) 
{ 
    if(!reproducing && (TimeUnit.MILLISECONDS.toSeconds(l) -
            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))) == 10){
         reproducirAviso();
    }

    tiempo.setText(String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(l),
            TimeUnit.MILLISECONDS.toSeconds(l) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))));

}