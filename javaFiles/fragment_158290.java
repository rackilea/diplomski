countValley(String s) {
    currentLevel = 0
    valleyCount = 0
    for (step in s) {
        if step == 'U' {
            ++currentLevel;
            if (currentLevel == 0) {  // returning to sea level
                ++valleyCount
            }
        } else if step == 'D' {
            --currentLevel;
        }
    }
    return valleyCount
}