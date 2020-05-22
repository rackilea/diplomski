public enum SpeechPart
{
    NOUN ("noun"),
    PLURAL ("plural"),
    NOUNPHRASE ("noun phrase"),
    ADVERB ("adverb"),
    ADJECTIVE ("adjective"),
    CONJUNCTION ("conjunction"),
    VERB ("verb");

    private String english;

    SpeechPart(String inEnglish)
    {
        this.english = inEnglish;
    }

    public String toString() { return english; }
}