class MyService extends Service{
Handler handler ;
onStartCommand(intent int , int flags,int startId){
handler = new Handler(); // this will get instantiated on the main thread;
new Thread(new Runnable() {

                    @Override
                    public void run() {
                        dispatchMessage("this is a toast");

                    }
                }).start();


}
public void dispatchMessage(final String message) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println(message);
                Toast.makeText(MyService.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

}