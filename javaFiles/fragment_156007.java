int[] levels = new int[] { -1, Level1, Level2, Level3 };

int level;
for (level = 0; level < levels.length && userXp < levels[level]; level++) { }
int minLevel = levels[level];
int maxLevel = levels[level + 1];
userLevelText.setText(Integer.toString(minLevel));