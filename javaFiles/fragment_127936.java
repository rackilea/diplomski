int delay = 1000; //milliseconds
  ActionListener taskPerformer = new ActionListener() {
      int count=0;
      public void actionPerformed(ActionEvent evt) {
           if(count==10) {//we did the task 10 times
                 ((Timer)evt.getSource()).stop();
            }

            label.setLocation((label.getLocationOnScreen().x+10), label.getLocationOnScreen().y);
            System.out.println(SwingUtilities.isEventDispatchThread());
           count++;
      }
  };
  new Timer(delay, taskPerformer).start();