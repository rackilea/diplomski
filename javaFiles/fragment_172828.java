@Configuration
public class AppBeans{
@Value("${minx:100}")
private double minX;
...so on ..
 @Bean
   public PointQuadTree pointQuadTree()
   {
      return new PointQuadTree(minX...so on);
   }

}