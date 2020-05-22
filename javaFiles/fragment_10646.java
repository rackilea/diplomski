public class AdaptedDocument extends AbstractDocument implements IDocumentListener {

private IDocument masterDocument;

private List<Integer> masterToSlaveMapping;
private List<Integer> slaveToMasterMapping;

private boolean setMaster = true;
private boolean replaceMaster = true;

public AdaptedDocument(IDocument masterDocument) {

    super();

    this.masterDocument = masterDocument;
    masterDocument.addDocumentListener(this);

    setTextStore(new CopyOnWriteTextStore(new GapTextStore()));
    setLineTracker(new DefaultLineTracker());
    getStore().set(masterDocument.get());
    getTracker().set(masterDocument.get());
    initializeMappings();
    completeInitialization();
}

private void initializeMappings() {

    masterToSlaveMapping = new ArrayList<Integer>();
    slaveToMasterMapping = new ArrayList<Integer>();

    for (int i=0; i<masterDocument.getLength(); i++) {
        masterToSlaveMapping.add(i);
        slaveToMasterMapping.add(i);
    }
}

@Override
public void replace(int pos, int length, String text) throws BadLocationException {
    if (replaceMaster) {
        masterDocument.replace(pos, length, text);
    }
    super.replace(pos, length, text);
}

@Override
public void replace(int pos, int length, String text, long modificationStamp) throws BadLocationException {
    if (replaceMaster) {
        masterDocument.replace(pos, length, text);
    }
    super.replace(pos, length, text, modificationStamp);
}

@Override
public void set(String text) {
    if (setMaster) {
        masterDocument.set(text);
    }
    super.set(text);
}

@Override
public void set(String text, long modificationStamp) {
    if (setMaster) {
        if (masterDocument instanceof AbstractDocument) {
            ((AbstractDocument) masterDocument).set(text, modificationStamp);
        }
        else {
            masterDocument.set(text);
        }
    }
    super.set(text, modificationStamp);
}

public IDocument getMasterDocument() {
    return this.masterDocument;
}

public void removeTextFromSlave(int offset, int length) throws BadLocationException {

    if (length == 0) {
        return;
    }

    try {
        replaceSlaveOnly(offset, length, "");

        for (int i=0; i<length; i++) {
            slaveToMasterMapping.remove(offset);
        }
    }
    catch (Exception e) {
        throw new BadLocationException();
    }

    rebuildMasterToSlaveMapping();
}

public void addTextToSlaveOnly(int offset, String text) throws BadLocationException {

    try {       
        replaceSlaveOnly(offset, 0, text);

        for (int i=0; i<text.length(); i++) {
            slaveToMasterMapping.add(offset + i, -1);
        }
    }
    catch (Exception e) {
        throw new BadLocationException();
    }

    rebuildMasterToSlaveMapping();
}

public void removeMasterDocumentRange(int offset, int length) throws BadLocationException {

    if (length == 0) {
        return;
    }

    StringBuffer buffer = new StringBuffer(get());

    try {
        int counter = 0;
        for (int i=0; i<length; i++) {
            int slaveOffset = masterToSlaveMapping.get(offset+i);
            if (slaveOffset != -1) {
                buffer.deleteCharAt(slaveOffset - counter);
                slaveToMasterMapping.remove(slaveOffset - counter);
                counter++;
            }
        }
    }
    catch (Exception e) {
        throw new BadLocationException();
    }

    setSlaveOnly(buffer.toString());

    rebuildMasterToSlaveMapping();
}

public void addMasterDocumentRange(int offset, int length) throws BadLocationException {

    if (length == 0) {
        return;
    }

    StringBuffer buffer = new StringBuffer(get());
    String masterString = masterDocument.get();

    try {       
        int counter = 0;
        for (int i=0; i<length; i++) {
            int slaveOffset = masterToSlaveMapping.get(offset+i);
            if (slaveOffset == -1) {
                int insertIndex = 0;
                for (int j=offset+i; j>=0; j--) {
                    if (masterToSlaveMapping.get(j) != -1) {
                        insertIndex = masterToSlaveMapping.get(j)+1;
                        break;
                    }
                }
                buffer.insert(insertIndex + counter, masterString.charAt(offset + i));
                slaveToMasterMapping.add(insertIndex + counter, offset+i);
                counter++;
            }
        }
    }
    catch (Exception e) {
        throw new BadLocationException();
    }

    setSlaveOnly(buffer.toString());

    rebuildMasterToSlaveMapping();
}

public int toMasterOffset(int offset) throws BadLocationException {
    try {
        return slaveToMasterMapping.get(offset);
    }
    catch (Exception e) {
        throw new BadLocationException();
    }
}

public int toSlaveOffset(int offset) throws BadLocationException {
    try {
        return masterToSlaveMapping.get(offset);
    }
    catch (Exception e) {
        throw new BadLocationException();
    }
}

public IRegion toMasterRegion(int offset, int length) throws BadLocationException {

    try {
        if (length == 0) {
            throw new BadLocationException();
        }
        int[] master = new int[length];
        for (int i=0; i<length; i++) {
            master[i] = slaveToMasterMapping.get(offset+i);
            if (i > 0) {
                if (master[i] != (master[i-1] + 1)) {
                    throw new BadLocationException();
                }
            }
        }
        return new Region(master[0], master.length);
    }
    catch (Exception e) {
        throw new BadLocationException();
    }
}

public IRegion toSlaveRegion(int offset, int length) throws BadLocationException {

    try {
        if (length == 0) {
            throw new BadLocationException();
        }
        int[] slave = new int[length];
        for (int i=0; i<length; i++) {
            slave[i] = masterToSlaveMapping.get(offset+i);
            if (i > 0) {
                if (slave[i] != (slave[i-1] + 1)) {
                    throw new BadLocationException();
                }
            }
        }
        return new Region(slave[0], slave.length);
    }
    catch (Exception e) {
        throw new BadLocationException();
    }
}

@Override
public void documentAboutToBeChanged(DocumentEvent event) {
}

@Override
public void documentChanged(DocumentEvent event) {
    setSlaveOnly(masterDocument.get());
}

private void setSlaveOnly(String text) {
    setMaster = false;
    super.set(text);
    setMaster = true;
}

private void replaceSlaveOnly(int pos, int length, String text) throws BadLocationException {
    replaceMaster = false;
    super.replace(pos, length, text);
    replaceMaster = true;
}

private void rebuildMasterToSlaveMapping() {

    int length = masterDocument.getLength();

    masterToSlaveMapping.clear();

    for (int i=0; i<length; i++) {
        masterToSlaveMapping.add(-1);
    }
    for (int i=0; i<slaveToMasterMapping.size(); i++) {
        int masterOffset = slaveToMasterMapping.get(i);
        if (masterOffset != -1) {
            masterToSlaveMapping.set(masterOffset, i);
        }
    }
}
}