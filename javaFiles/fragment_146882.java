package internal.secrets;

import external.character.Character;

public interface SecretCharacter
{
    /**
     * @param character a character
     * @return the character's introductory phrase
     */
    String getPhrase(Character character);
}