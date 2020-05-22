String result = String.format("%s%s", getLabel(), ":");

    int tabs = result.length()/4;
    int desiredTabs = 7;
    for(int i = 0; i < desiredTabs-tabs) {
        result += "\t";
    }
    result += "Weight = " + getWeight() + " Dimensions = " + getHeight() + " X " + getWidth() + " X " + getLength();

    return result;