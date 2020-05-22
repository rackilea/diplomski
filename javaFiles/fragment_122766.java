public static void main(String[] args) throws IOException, PatchFormatException, PatchApplyException {

    for (String arg : args) {
        System.out.println(arg);
    }
    // args[0] - patch file path
    String patchFilePath = "C:\\JenkinsNew\\workspace\\ValidateJob\\diffPatch.patch";

    Patch patch = new Patch();
    patch.parse(new FileInputStream(new File(patchFilePath)));
    if (!patch.getErrors().isEmpty())
        throw new PatchFormatException(patch.getErrors());
    for (FileHeader fh : patch.getFiles()) {
        File file = getFile(fh.getOldPath(), false, "");
        List<String> apply = apply(file, fh);
        for (String s : apply) {
            System.out.println(s);
        }
    }
}

private static File getFile(String path, boolean create, String workSpacePath)
        throws PatchApplyException {
    // args[1] : the workspace
    File f = new File("C:\\JenkinsNew\\workspace\\ValidateJob", path);
    if (create)
        try {
            File parent = f.getParentFile();
            FileUtils.mkdirs(parent, true);
            FileUtils.createNewFile(f);
        } catch (IOException e) {
            throw new PatchApplyException(MessageFormat.format(JGitText.get().createNewFileFailed, f), e);
        }
    return f;
}

private static List<String> apply(File f, FileHeader fh)
        throws IOException, PatchApplyException {
    RawText rt = new RawText(f);
    List<String> oldLines = new ArrayList<>(rt.size());
    for (int i = 0; i < rt.size(); i++)
        oldLines.add(rt.getString(i));
    List<String> newLines = new ArrayList<>(oldLines);
    List<String> newLineToBeAdded = new ArrayList<>();
    for (HunkHeader hh : fh.getHunks()) {

        byte[] b = new byte[hh.getEndOffset() - hh.getStartOffset()];
        System.arraycopy(hh.getBuffer(), hh.getStartOffset(), b, 0, b.length);
        RawText hrt = new RawText(b);

        List<String> hunkLines = new ArrayList<>(hrt.size());
        for (int i = 0; i < hrt.size(); i++)
            hunkLines.add(hrt.getString(i));
        int pos = 0;
        for (int j = 1; j < hunkLines.size(); j++) {
            String hunkLine = hunkLines.get(j);
            switch (hunkLine.charAt(0)) {
                case '-':
                    if (hh.getNewStartLine() == 0) {
                        newLines.clear();
                    } else {
                        if (!(newLines.get(hh.getNewStartLine() - 1 + pos).replaceAll("([\\r\\n])", "")).equals(hunkLine.substring(1))) {
                            throw new PatchApplyException(MessageFormat.format(JGitText.get().patchApplyException, hh));
                        }
                        newLines.remove(hh.getNewStartLine() - 1 + pos);
                    }
                    break;
                case '+':
                    newLines.add(hh.getNewStartLine() - 1 + pos,hunkLine.substring(1));
                    newLineToBeAdded.add(hunkLine.substring(1));
                    pos++;
                    break;
            }
        }
    }
    return newLineToBeAdded;
}