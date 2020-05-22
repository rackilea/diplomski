String[] words = str.split(" ");
StringBuilder sb = new StringBuilder();

// So don't include the first and last word as they are "[12]" and "(12.4%)".
// It doesn't matter how many words you have as we use words.length
for (int i = 1; i < words.length - 1; ++i) 
{
    // you could figure out a better method to add "_"
    if (i != 1)
    {
        sb.append("_");
    }
    sb.append(words[i]);
}
String result = sb.toString();