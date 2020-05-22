12:20:34.037 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory - Creating shared instance of singleton bean 'auditorium'
12:20:34.038 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory - Creating instance of bean 'auditorium'
12:20:34.045 [main] DEBUG o.s.c.a.CommonAnnotationBeanPostProcessor - Found init method on class [com.example.Auditorium]: private void com.example.Auditorium.doAfterConstruction()
12:20:34.045 [main] DEBUG o.s.c.a.CommonAnnotationBeanPostProcessor - Registered init method on class [com.example.Auditorium]: org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleElement@1ec4fbf0
12:20:34.060 [main] DEBUG o.s.b.f.annotation.InjectionMetadata - Registered injected element on class [com.example.Auditorium]: AutowiredFieldElement for private java.lang.String com.example.Auditorium.name
12:20:34.060 [main] DEBUG o.s.b.f.annotation.InjectionMetadata - Registered injected element on class [com.example.Auditorium]: AutowiredFieldElement for private java.lang.Integer com.example.Auditorium.numberOfSeats
12:20:34.060 [main] DEBUG o.s.b.f.annotation.InjectionMetadata - Registered injected element on class [com.example.Auditorium]: AutowiredFieldElement for private java.util.List com.example.Auditorium.vipSeats
12:20:34.060 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory - Eagerly caching bean 'auditorium' to allow for resolving potential circular references
12:20:34.062 [main] DEBUG o.s.b.f.annotation.InjectionMetadata - Processing injected element of bean 'auditorium': AutowiredFieldElement for private java.lang.String com.example.Auditorium.name
12:20:34.067 [main] DEBUG o.s.b.f.annotation.InjectionMetadata - Processing injected element of bean 'auditorium': AutowiredFieldElement for private java.lang.Integer com.example.Auditorium.numberOfSeats
12:20:34.072 [main] DEBUG o.s.b.f.annotation.InjectionMetadata - Processing injected element of bean 'auditorium': AutowiredFieldElement for private java.util.List com.example.Auditorium.vipSeats
12:20:34.084 [main] DEBUG o.s.c.a.CommonAnnotationBeanPostProcessor - Invoking init method on bean 'auditorium': private void com.example.Auditorium.doAfterConstruction()
12:20:34.085 [main] DEBUG com.example.Auditorium - Auditorium{id=null, name='yellow hall', numberOfSeats=150, vipSeats=[1,2,3,4,5,6,7,8,9]}
12:20:34.094 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory - Finished creating instance of bean 'auditorium'