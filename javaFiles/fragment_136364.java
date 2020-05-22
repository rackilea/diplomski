@Component @Red @Black public class Apple1 implements IApple {} //fall back
@Component @Black @Primary public class Apple2 implements IApple {}

@Component public class AppleEater {
  @Inject @Black IApple blackApple; // -> Apple2
  @Inject @Red IApple redApple; // -> Apple1
}