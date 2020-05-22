// create a new empty slide show
    XMLSlideShow ppt = new XMLSlideShow();

    // add first slide
    XSLFSlide slide = ppt.createSlide();

    // get or create notes
    XSLFNotes note = ppt.getNotesSlide(slide);

    // insert text
    for (XSLFTextShape shape : note.getPlaceholders()) {
        if (shape.getTextType() == Placeholder.BODY) {
            shape.setText("String");
            break;
        }
    }

    // save
    [...]