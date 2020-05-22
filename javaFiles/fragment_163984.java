final StringBuilder builder = new StringBuilder(words.length * 8);
for (String[] nestedWords : words)
{
    builder.append(nestedWords[0]);
}

return builder.toString();