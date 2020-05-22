public void split(TextPaint textPaint, String filepath,Context context) {
        File file = new File(filepath);
        char[] bufferChar = new char[512];
        //How lines on page
        int maxLinesOnpage = 0;
        int symbolsOnLine = 0;
        StaticLayout staticLayout = new StaticLayout(
                context.getString(R.string.lorem_ipsum),//short text with 100 lines (\r\n\r\n\r\n\r\n\r\n\r\n)
                textPaint, //MONOSPACE!!!
                pageWidth,
                Layout.Alignment.ALIGN_NORMAL,
                lineSpacingMultiplier,
                lineSpacingExtra,
                false
        );
        int startLineTop = staticLayout.getLineTop(0);
        int endLine = staticLayout.getLineForVertical(startLineTop + pageHeight);
        int endLineBottom = staticLayout.getLineBottom(endLine);
        if (endLineBottom > startLineTop + pageHeight) {
            maxLinesOnpage = endLine - 1;
        } else {
            maxLinesOnpage = endLine;
        }
        symbolsOnLine = staticLayout.getLineEnd(0);

        try {
            RandomAccessFile rac = new RandomAccessFile(file, "r");
            byte[] buffer = new byte[2048];
            int wordLen = 0; //Length of word in symbols
            int wordInBytes = 0; //Lenght of word
            int startLinePos = 0; //Start first line position
            int lineWidth = 0; //Current line length
            int totalLines =0; //Total lines on current page
            Log.e("Start pagination", "" + totalLines);
            long timeout= System.currentTimeMillis();
            int buflen=0; //buffer size
            int totalReadedBytes = 0; //Total bytes readed
            byte skipBytes = 0;
            while ( (buflen=rac.read(buffer))!=-1){
                for (int i=0;i<buflen;i++) {
                    totalReadedBytes++;
                    wordInBytes++;
                    if (skipBytes==0){ //Bytes on one symbol
                        if (unsignedToBytes(buffer[i])>=192){skipBytes=2;}
                        if (unsignedToBytes(buffer[i])>=224){skipBytes=3;}
                        if (unsignedToBytes(buffer[i])>=240){skipBytes=4;}
                        if (unsignedToBytes(buffer[i])>=248){skipBytes=5;}
                        if (unsignedToBytes(buffer[i])>=252){skipBytes=6;}
                    }
                    //Full bytes on symbol or not
                    if (skipBytes>0){
                        skipBytes--;
                        if (skipBytes>0){continue;}
                    }

                    if (buffer[i] == 13) {//We have a \r symbol. Ignore.
                        continue;
                    }



                    if (buffer[i]==10){//New line symbol
                        if (lineWidth + wordLen>symbolsOnLine){
                            totalLines++;
                            if (totalLines > maxLinesOnpage) {
                                int[] pgsbytes = {startLinePos, totalReadedBytes};
                                pages.add(pgsbytes);
                                startLinePos = totalReadedBytes ;
                                totalLines = 0;
                            }
                        }
                        wordLen=0;
                        wordInBytes=0;
                        totalLines++;
                        lineWidth=0;
                        if (totalLines>maxLinesOnpage){
                            int[] pgsbytes = {startLinePos, totalReadedBytes-1};
                            pages.add(pgsbytes);
                            startLinePos = totalReadedBytes-1;
                            totalLines=0;
                        }
                    }

                    if (buffer[i]==32){//Space symbol
                        if (lineWidth + wordLen+1<=symbolsOnLine){//Word fits in line
                            lineWidth+=wordLen + 1;
                            wordLen=0;
                            if (lineWidth==symbolsOnLine){
                                totalLines++;
                                if (totalLines > maxLinesOnpage) {
                                    int[] pgsbytes = {startLinePos, totalReadedBytes};
                                    pages.add(pgsbytes);
                                    startLinePos = totalReadedBytes ;
                                    totalLines = 0;
                                }
                                lineWidth = 0;
                                wordLen = 0;
                                wordInBytes=0;
                            }
                        } else {
                            if (lineWidth + wordLen==symbolsOnLine){
                                totalLines++;
                                if (totalLines > maxLinesOnpage) {
                                    int[] pgsbytes = {startLinePos, totalReadedBytes};
                                    pages.add(pgsbytes);
                                    startLinePos = totalReadedBytes ;
                                    totalLines = 0;
                                }
                                lineWidth = 0;
                                wordLen = 0;
                                wordInBytes=0;
                            } else {
                                totalLines++;
                                if (totalLines > maxLinesOnpage) {
                                    int[] pgsbytes = {startLinePos, totalReadedBytes - 1 - wordInBytes};
                                    pages.add(pgsbytes);
                                    startLinePos = totalReadedBytes - 1;
                                    totalLines = 0;
                                }
                                lineWidth = wordLen + 1;
                                wordLen = 0;
                                wordInBytes=0;
                            }
                        }
                    }

                    if (buffer[i]!=32&&buffer[i]!=10&&buffer[i]!=13){wordLen++; }
                    if (wordLen==symbolsOnLine){
                        totalLines++;
                        if (totalLines>maxLinesOnpage){
                            int[] pgsbytes = {startLinePos, totalReadedBytes-1  - wordInBytes};
                            pages.add(pgsbytes);
                            startLinePos = totalReadedBytes-1;
                            totalLines=0;
                        }
                        lineWidth=0;
                        wordLen=0;
                        wordInBytes=0;
                    }
                }

            }
            rac.close();
            timeout = System.currentTimeMillis() - timeout;
            Log.e("TOTAL Time",  " time " + timeout + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e("FILE READED FULLY!!", "READ COMPLETE!!!!!!!!!!!!!!!!");
    }