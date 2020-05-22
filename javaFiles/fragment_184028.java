for (int ind = 0; ind < boxes.size(); ind++) {
    try {
        wt.until(textInValue(boxes.get(ind)));
    }
    catch (TimeoutException e) {
        // print message
    }
}