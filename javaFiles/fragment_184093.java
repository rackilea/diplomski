for(int i = 0 ; i < localitate.length; i++)
{
    String tmp = "";
    String[] words = localitate[i].split(" ");
    for (int j = 0; j < words.length; j++) {
        tmp += words[j].substring(0, 1).toUpperCase() + words[j].substring(1).toLowerCase() + " ";
    }
    localitate[i] = tmp.trim(); // trim is to delete last space
}