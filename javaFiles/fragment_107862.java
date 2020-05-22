@Stateless
public class MyBean {

  @EJB(beanName = "Bean1")
  MyRunnable bean1;

  @EJB(beanName = "Bean2")
  MyRunnable bean2;

  public void run() {
    MyRunnable r = Math.random() < 0.5d ? bean1 : bean2;
    r.run(10);
  }
}