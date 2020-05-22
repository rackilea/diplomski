// Now add notes slide.
    // 1. Notes master
    NotesMasterPart nmp = new NotesMasterPart();
    NotesMaster notesmaster = (NotesMaster)XmlUtils.unmarshalString(notesMasterXml, Context.jcPML);
    nmp.setJaxbElement(notesmaster);
    // .. connect it to /ppt/presentation.xml
    Relationship ppRelNmp = pp.addTargetPart(nmp);
    /*
     *  <p:notesMasterIdLst>
            <p:notesMasterId r:id="rId3"/>
        </p:notesMasterIdLst>
     */
    pp.getJaxbElement().setNotesMasterIdLst(createNotesMasterIdListPlusEntry(ppRelNmp.getId()));

    // .. NotesMasterPart typically has a rel to a theme 
    // .. can we get away without it? 
    // Nope .. read this in from a file
    ThemePart themePart = new ThemePart(new PartName("/ppt/theme/theme2.xml"));
        // TODO: read it from a string instead
    themePart.unmarshal(
            FileUtils.openInputStream(new File(System.getProperty("user.dir") + "/theme2.xml"))
        );      
    nmp.addTargetPart(themePart);

    // 2. Notes slide
    NotesSlidePart nsp = new NotesSlidePart();
    Notes notes = (Notes)XmlUtils.unmarshalString(notesXML, Context.jcPML);
    nsp.setJaxbElement(notes);
    // .. connect it to the slide
    slidePart.addTargetPart(nsp);
    // .. it also has a rel to the slide
    nsp.addTargetPart(slidePart);
    // .. and the slide master
    nsp.addTargetPart(nmp);