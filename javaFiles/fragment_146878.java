package external.main;

import external.character.Character;
import external.story.Story;

public class Main
{
    public static void main(String[] args)
    {
        Story story = new Story();
        story.introduce(Character.HARRY_POTTER);
        story.introduce(Character.RON_WEASLEY);
        story.introduce(Character.HERMIONE_GRANGER);
    }
}