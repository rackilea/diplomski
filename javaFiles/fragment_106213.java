final JTabbedPane characterInfoPane = new JTabbedPane();

TextPane[] textPanes = new TextPane[4];
while (setupPlayerIndex < 4) {
    textPanes[setupPlayerIndex] = new TextPane();
    characterInfoPane.addTab(minirpg.MiniRPG.players.get(setupPlayerIndex).getName(), null, textPanes[setupPlayerIndex],
            "");
    setupPlayerIndex++;
}