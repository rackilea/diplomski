Element player = document.createElement("player");
player.setAttribute("id","3");

Element name = document.createElement("name");
name.setTextContent("Player 3");
player.appendChild(name);

Element level = document.createElement("level");
level.setTextContent("4");
player.appendChild(level);

Element score = document.createElement("score");
score.setTextContent("10000");
player.appendChild(score);

Element games = document.findElementsByTag("games").item(0);
games.appendChild(player);