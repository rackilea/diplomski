package external.story;

import external.character.Character;
import internal.secrets.SharedSecrets;

public final class Story
{
    /**
     * Introduces a character.
     *
     * @param character the character
     */
    public void introduce(Character character)
    {
        System.out.println(character.name() + " enters the room and says: " + SharedSecrets.INSTANCE.secretCharacter.getPhrase(character));
    }
}