for (int i = 1; i <= numberOfFiles; i++) {
        lineCount = 0;

        while (myScanners.get(i - 1).hasNext()) {
            increment = myScanners.get(i - 1).nextLine();
            lineCount++;
        }

        lineCounts.add(lineCount);
    }

 myScanners.clear()

 for (int k = 1; k <= numberOfFiles; k++)
        myScanners.add(new Scanner(new File("input" + k + ".txt")));

 // Find the minimum file count.
int minLineCount = Collections.min(lineCounts);