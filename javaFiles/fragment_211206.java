boolean found = false;
for (int i = 0, n = player.get_charactersOwned().size(); i < n && !found; i++) {
    Character c = player.get_charactersOwned().get(i);
    if (c.get_characterName().equals(charName)) {
        found = true;
    }
}