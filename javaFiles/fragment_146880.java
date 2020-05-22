package external.character;

import internal.secrets.SecretCharacter;
import internal.secrets.SharedSecrets;

public enum Character
{
    HARRY_POTTER
    {
        @Override
        String getPhrase()
        {
            return "Your bird, there was nothing I could do. He just caught fire.";
        }
    },
    RON_WEASLEY
    {
        @Override
        String getPhrase()
        {
            return "Who are you and what have you done with Hermione Granger?";
        }
    },
    HERMIONE_GRANGER
    {
        @Override
        String getPhrase()
        {
            return "I'm not an owl!";
        }
    };

    static
    {
        SharedSecrets.INSTANCE.secretCharacter = new SecretCharacter()
        {
            @Override
            public String getPhrase(Character character)
            {
                return character.getPhrase();
            }
        };
    }

    /**
     * @return the character's introductory phrase
     */
    abstract String getPhrase();
}