import java.util.ArrayList;
import java.util.Map;
import com.my.ContextDroolsObject;

dialect 'java'


rule 'Soccer Image Theme'
salience 100
when
    s : ContextDroolsObject( imageThemesList : objects#Map.get("imageThemes") )
then
    System.out.println("-----------------------soccer");
end