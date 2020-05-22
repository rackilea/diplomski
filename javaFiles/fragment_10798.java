@Module
public class ApplicationModule {
private Shape rec;
private Shape circle;

public ApplicationModule() {
    rec = new Rectangle();
    circle= new Circle ();
}

@Provides
 @Named("rect")
public Shape provideRectangle() {
    return rec ;
}

@Provides
 @Named("circle")
public Shape provideCircle() {
    return circle;
}