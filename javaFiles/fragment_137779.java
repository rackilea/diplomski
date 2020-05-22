public void run(){
                System.out.println("visualizer being launched...");
                Visualizer visualizer = new Visualizer(manager);
                visualizer.init();//This is pretty important
                visualizer.setVisible(true);
        }