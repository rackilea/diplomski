public String findFaceValue(int index)
{
    String faceValueArray[] = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
                               "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    if (index < 0 || index >= faceValueArray.length)
        return "Not a valid card";
    return faceValueArray[index];
}