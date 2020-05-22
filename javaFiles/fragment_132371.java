Regex r = new Regex("=([^;]*);");
Match m = r.Match(yourData);
while (m.Success) {
    string match = m.Groups[1];
    // match should be the text between the '=' and the ';'.
}