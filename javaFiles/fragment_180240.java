int[] levelCurrentValues = new int[] {0,0,0};

for (XWPFParagraph paragraph : paragraphList) {
    String levelText = paragraph.getNumLevelText();
    BigInteger levelDepth = paragraph.getNumIlvl();
    String levelFormat = paragraph.getNumFmt();
    System.out.println("text: "+levelText);
    System.out.println("depth: "+levelDepth);
    System.out.println("format: "+levelFormat);

    if(levelText!=null) {
        levelCurrentValues[levelDepth.intValue()] += 1;

        levelText = levelText.replace("%1", "" + levelCurrentValues[0]);
        levelText = levelText.replace("%2", "" + levelCurrentValues[1]);
        levelText = levelText.replace("%3", "" + levelCurrentValues[2]);
        System.out.println(levelText);
        System.out.println("");
    }
}