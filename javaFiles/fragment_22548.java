public static ArrayList<String> usbDriveList() throws FileNotFoundException {

    final String MTB_ADDRESS = "/etc/mtab";
    final String TARGET = "^/media/usb[0-7]$"; // REGEX

    final File file = new File(MTB_ADDRESS);
    final ArrayList<String> driveList = new ArrayList<String>();

    try (Scanner in = new Scanner(file)) {
        while (in.hasNext()) {
            final String[] splitLine = in.nextLine().split(" ");
            if (splitLine[1].matches(TARGET)) {
                driveList.add(splitLine[1]); // got it!
            }
        }
    } catch (final FileNotFoundException e) {
        throw new FileNotFoundException();
    }

    return driveList;
}