public class SomethingThatShouldHappenInAThread {
     private TaskExecutor taskExecutor;
     private ClassWithMethodToFire classWithMethodToFire;

     public SomethingThatShouldHappenInAThread(TaskExecutor taskExecutor,
                                               ClassWithMethodToFire classWithMethodToFire) {
          this.taskExecutor = taskExecutor;
          this.classWithMethodToFire = classWithMethodToFire;
     }

     public void fire(final SomeParameterClass parameter) {
          taskExecutor.execute( new Runnable() {
               public void run() {
                    classWithMethodToFire.doSomething( parameter );
               }
          });
     }
}