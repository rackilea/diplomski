public static int counter=0;
public void runMother(final Handler handler)
{
if(counter==3)return;
handler.postDelayed(new Runnable() {
    @Override
    public void run() {

        members.get(counter).setBackgroundColor(Color.GREEN);
        counter++;
        runMother(handler);

    }
}, 1000*counter);