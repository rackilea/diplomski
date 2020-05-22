private Task task1;
   private Task2 task2;

 public void actionPerformed (ActionEvent e){

      if (e.getSource()==jbtStart)
      {

          System.out.println("Start is pressed");
          if (task2 != null) {
              task2.cancel();
          }
          task1 = new Task();
          timer.schedule(task1, 0, delay);
      }

      else if (e.getSource()==jbtStop)
      {   
            System.out.println("Stop is pressed");
            if (task1 != null) {
                task1.cancel();
            }
            task2 = new Task2();
            timer.schedule(task2, 0, delay);
      }