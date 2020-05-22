for (int x = 0; x < map.length; x++) {   // use map.length here for rows
    for (int y = 0; y < map[0].length; y++) {  // use map[0].length here for columns
        if (map[x][y] == -1) {   // use x for rows and y for columns
            continue;
        }
        renderer.getGraphics().drawImage(tileSet.get(map[x][y]).getTexture(), (x * tileSize) + xOffs, (y * tileSize) + yOffs, null);
     }
}