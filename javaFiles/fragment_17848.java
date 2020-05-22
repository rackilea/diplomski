import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    public class SpellsList {

        static List<Spell> spellsList = new ArrayList<Spell>();

        static {

            spellsList.add(new Spell("Fireball", "damage", 5));
            spellsList.add(new Spell("Ice Storm", "damage", 8));
            spellsList.add(new Spell("Heal", "heal", 8));

        }

        static String getSpellEffect(String spellName) {

            String spellEffect = "";

            for (Iterator<Spell> iter = spellsList.iterator(); iter.hasNext();) {
                Spell spell = iter.next();
                if (spellName.equals(spell.getSpellName())) {
                    spellEffect = spell.getEffect();
                    break;
                }
            }
            return spellEffect;

        }
    }