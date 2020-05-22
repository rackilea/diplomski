if (removeIndex >= nameArr.length)
    return count;

if (nameArr[removeIndex] == null)
    return count;

nameArr[removeIndex] = null;
passwordArr[removeIndex] = null;

return count - 1;