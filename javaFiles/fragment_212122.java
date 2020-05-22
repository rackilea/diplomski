private Thread Fill = new Thread(new Runnable(){
         @Override
        public void run(){
            while(currentStorage < _maxCapacity){
                currentStorage += _flux;
                try{Thread.sleep(500);}catch(Exception ex){}
                SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                revalidate();
                repaint();
                }
                });
            }
        }
    });