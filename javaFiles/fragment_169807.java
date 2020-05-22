Timer timer = new Timer();
TaskState state = new InitialState();

timer.schedule( new TimerTask() {
     public void run() {
          this.state.run();
          if( shouldChangeState() ) {
              this.state = this.state.next();
           }
     }
 }, 0, 1000 );