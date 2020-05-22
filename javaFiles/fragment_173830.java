private string SoundexByWord(string data)
{
    var soundexes = new List<string>();
    foreach(var str in data.Split(' ')){
        soundexes.Add(Soundex(str));
    }
#if Net35OrLower
    // string.Join in .Net 3.5 and before require the second parameter to be an array.
    return string.Join(" ", soundexes.ToArray());
#endif
    // string.Join in .Net 4 has an overload that takes IEnumerable<string>
    return string.Join(" ", soundexes);
}