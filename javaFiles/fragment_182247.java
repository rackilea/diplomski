@SpringBootApplication
// Be sure to add EnableAspectJAutoProxy and set proxyTargetClass to true
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DemoApplication {
  ...
}