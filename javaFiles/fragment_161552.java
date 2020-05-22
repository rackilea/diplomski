public colorize(int offset, int length) {
    long triggerTime[] = new long[length];
    long startTime = System.currentTimeMillis();
    for (int i=0; i<length; i++) {
         triggerTime[i] = startTime + (1000*i)/length;
    }

    for (int i=0; i<length; i++) {
        //just wait for the next time to occur
        Thread.sleep(triggerTime[i]-System.currentTimeMillis());
        doc.setCharacterAttributes(offset, i+1, textpane.getStyle("Red"), true);
    }
}