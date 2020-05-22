for (Material m : blockedlevel1) {
    if (m.equals(searchedMaterial)) { // assuming that equals() was overriden
        // found it! do something with it
        break;
    }
}