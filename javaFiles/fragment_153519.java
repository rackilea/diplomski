while(true){
                    SourceDataLine sourcedataline = (SourceDataLine) AudioSystem.getLine(datalineinfo);
                    sourcedataline.open(audioformat);
        /...
                        sourcedataline.write(sounddata, 0, numberofbytesread);
                    }
}