while(index>=0) {
        index = findtextarea.indexOf(findstr,index);
        if (index > 0) {
           h.addHighlight(index,index+findstrLength, DefaultHighlighter.DefaultPainter);
        }
        index++; // try adding this to allow you to look for the next index.
    }