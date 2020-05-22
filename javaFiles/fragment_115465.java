String currItem = stringListIter.next();
if(currItem.startsWith(textToFind.concat(space))){
    retList.add(currItem);
} else if(currItem.endsWith(space.concat(textToFind))){
    retList.add(currItem);
} else if(currItem.contains(space.concat(textToFind).concat(space))){
    retList.add(currItem);
} else if(currItem.equals(textToFind)){
    retList.add(currItem);
}