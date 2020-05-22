// A C# Dictionary is a hash table
Dictionary<string, string> dict = new Dictionary<string, string>();
dict.Add("BFF", "Best Friend Forever");
// Add the rest of the abbreviations

// Loop over every key (abbreviation) in the hash table
foreach (string abbreviation in dict.Keys) {
    // If the string contains the abbreviation
    if (f.contains(abbreviation)) {

         Console.WriteLine(abbreviation + ": " + dict[key]);
    }
}