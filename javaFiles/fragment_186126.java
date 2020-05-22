@Bean
//Load this bean only if Container<Car> isn't present
@ConditionalOnMissingGenericBean(containerType=Container.class, typeParameters=Car.class)
public Container<Computer> computerContainer() {
    return new Container<>(new Computer());
}