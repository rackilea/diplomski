public string GetPlural(string singular)
{
    string CONSONANTS = "bcdfghjklmnpqrstvwxz";

    switch (singular)
    {
        case "Person":
            return "People";
        case "Trash":
            return "Trash";
        case "Life":
            return "Lives";
        case "Man":
            return "Men";
        case "Woman":
            return "Women";
        case "Child":
            return "Children";
        case "Foot":
            return "Feet";
        case "Tooth":
            return "Teeth";
        case "Dozen":
            return "Dozen";
        case "Hundred":
            return "Hundred";
        case "Thousand":
            return "Thousand";
        case "Million":
            return "Million";
        case "Datum":
            return "Data";
        case "Criterion":
            return "Criteria";
        case "Analysis":
            return "Analyses";
        case "Fungus":
            return "Fungi";
        case "Index":
            return "Indices";
        case "Matrix":
            return "Matrices";
        case "Settings":
            return "Settings";
        case "UserSettings":
            return "UserSettings";
        default:
            // Handle ending with "o" (if preceeded by a consonant, end with -es, otherwise -s: Potatoes and Radios)
            if (singular.EndsWith("o") && CONSONANTS.Contains(singular[singular.Length - 2].ToString()))
            {
                return singular + "es";
            }
            // Handle ending with "y" (if preceeded by a consonant, end with -ies, otherwise -s: Companies and Trays)
            if (singular.EndsWith("y") && CONSONANTS.Contains(singular[singular.Length - 2].ToString()))
            {
                return singular.Substring(0, singular.Length - 1) + "ies";
            }
            // Ends with a whistling sound: boxes, buzzes, churches, passes
            if (singular.EndsWith("s") || singular.EndsWith("sh") || singular.EndsWith("ch") || singular.EndsWith("x") || singular.EndsWith("z"))
            {
                return singular + "es";
            }
            return singular + "s";

    }
}