try {
        base = StartingClass.class.getResource("/data/background.png");
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Image Setups
    character = getImage(base, "character.png");
    characterDown = getImage(base, "down.png");
    ...