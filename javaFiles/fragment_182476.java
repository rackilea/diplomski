for (int i = 0; i < alNumber.size(); i++) {
    int currentLevel = alLevel.get(i);
    Element node = xmlDocument.createElement("node");
    node.setAttribute("number", alNumber.get(i));
    node.setAttribute("name", alName.get(i));

    int levelDifference = previousLevel - currentLevel + 1;

    while(levelDifference > 0 ) {
        elementStack.remove(elementStack.size() - 1);
        levelDifference--;
    }

    if(i == 0) {
        xmlDocument.appendChild(node);
    } else {
        Element parentElement = elementStack.get(currentLevel - 1);
        parentElement.appendChild(node);
        elementStack.set(currentLevel - 1,  parentElement);
    }
    elementStack.add(node);
    previousLevel = currentLevel;
    }