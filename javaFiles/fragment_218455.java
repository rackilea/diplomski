@Retention(RetentionPolicy.RUNTIME)
@interface Flyer {
}

@Retention(RetentionPolicy.RUNTIME)
@interface Swimmer {
}

@Flyer @Swimmer
public class Penguin implements Animal {
}