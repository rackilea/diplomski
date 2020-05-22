public ImageSlide2(int x, int y, int width, int height) {
    setBounds(x, y, width, height);
    //Call The Function SetImageSize
    SetImageSize(list.length - 1);


    new Thread(new Runnable() {
        public void run() {
            while(true)
            try {
                System.out.println(xx);
                SetImageSize(xx);
                xx += 1;
                if (xx >= list.length) {
                    xx = 0;
                }
                Thread.sleep(1000);
            } catch (Exception ie) { ie.printStackTrace();
            }

        }
    }).start();

}