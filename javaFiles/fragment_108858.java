int skillPoint = 10;
    int currLevel = 0;

    Object[] options = {"Upgrade", "Cancel"};
    SkillPane pane = new SkillPane(currLevel, 100, skillPoint);

    if (JOptionPane.showOptionDialog(null, pane, "Upgrade Skill", 1, 3, null, options, options[0]) == 0) {
        int value = pane.getValue();

        if ((skillPoint - value - currLevel) >= 0) {
            currLevel++;
            JOptionPane.showMessageDialog(null, "You've successfully upgraded this skill to level " + currLevel);
        } else {
            JOptionPane.showMessageDialog(null, "You do not have enough skill point!");
        }
    }