public class AnimalService implements ApplicationContextAware {

private ApplicationContext applicationContext;

@Override
public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
}


public String doSound(String animalName) {
    Animal animal = applicationContext.getBean(animalName);
return animal.sound();
 }

}