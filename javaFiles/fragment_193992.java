for (int count = 0; count < userString.length(); count++)
{
    char ch = userString.charAt(count);
    ch = Character.toLowerCase(ch);

    if (vowels.containsKey(ch)) {
        vowels.put(ch, vowels.get(ch) + 1); 
    }
}

System.out.println(vowels);  // Will print each vowels with respective count