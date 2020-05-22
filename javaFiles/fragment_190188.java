String result = String.format("%s%s", getLabel(), ":");

    int tabs = result.length()/4;
    int desiredTabs = 7;
    for(int i = 0; i < desiredTabs-tabs) {
        result += "\t";
    }
    result += String.format("%-7s%-2s%-5d%-11s%-2s%-3d%-2s%-3d%-2s%d",
            "Weight", "=", getWeight(), "Dimensions",
            "=", getHeight(), "X", getWidth(), "X", getLength());
    return result;