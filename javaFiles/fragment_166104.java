@RequiredArgsConstructor
   @Component
    public class C {
      //Here it will inject the implementation of A interface with name of implementation (As we have name of impl B we declare field as b , if HelloBeanImpl then helloBeanImpl
     private A b;
    }