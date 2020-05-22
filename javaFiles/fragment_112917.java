private static Card[] Deck = new Card[60];

// Constructor to return String variable "cardName",    
// which is later used by the MTGgui class.
public static String draw()
{   
    Random gen = new Random();

    String returningCardName = "";

    int i = 0;
    // i will be always 0...
    if (i < Deck.length)
    {
        int drawnCard = gen.nextInt(5) + 0;

        switch (drawnCard)
        {
        case 0: returningCardName = "Instant"; break;
        case 1: returningCardName = "Sorcery"; break;
        case 2: returningCardName = "Creature"; break;
        case 3: returningCardName = "Enchantment"; break;
        case 4: returningCardName = "Land"; break;
        case 5: returningCardName = "Artifact"; break;
        default: returningCardName = "Nothing!"; break;
        }

    }
    return returningCardName;
}