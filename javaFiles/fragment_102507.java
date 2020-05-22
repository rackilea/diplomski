public interface CreatableFromStringFactory<T> {
  public T createFromString( String s );
}

...

public class BooleanFromStringFactory implements CreatableFromStringFactory<Boolean> {
  public Boolean createFromString( String s ) {
    if ( s.equals( "yes" ) ) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE; 
  }
}

...
booleanFromStringFactory  = new BooleanFromStringFactory();
...
Boolean c = name_game.askUser("Is this correct?",booleanFromStringFactory );