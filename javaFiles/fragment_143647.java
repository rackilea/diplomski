import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MonsterCreator {

    private Monster[] monsterTypes;

    public MonsterCreator ( ) {
        monsterTypes = new Monster[2];
        monsterTypes[0] = new Zombie ( );
        monsterTypes[0] = new Skeleton ( );
    }

    public void tick ( ) {
        for ( Monster m : monsterTypes ) {
            if ( m.canBeCreated ( ) ) {
                try {
                    Constructor< ? >[] constr = m.getClass ( )
                        .getConstructors ( );
                    Monster toAdd = ( Monster ) constr[0].newInstance ( );
                    MonsterContainer.add ( toAdd );
                } catch ( InstantiationException | IllegalAccessException
                    | IllegalArgumentException | InvocationTargetException e ) {
                    e.printStackTrace ( );
                }
            }
        }
    }

}