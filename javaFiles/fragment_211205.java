// search the name
boolean found = false;
for (Character c : player.get_charactersOwned()) {
    if (c.get_characterName().equals(charName)) {
        found = true;
        break;
    }
}

// perform the check
if (found) {
    // do something
} else {
    // do something else
}