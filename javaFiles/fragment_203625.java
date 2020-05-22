static String[] prompts = { "title (Mr., Ms., Dr., etc.)", "first name", "lastname", //
        "street address", "city", "state (IL, MO, etc.)", "zip (e.g., 62025)" };
public static String[] getLabelData() {
    String[] nameAddressArray = new String[7];
    for (int i = 0; i < nameAddressArray.length; i++) {
        nameAddressArray[i] = String.format("Enter %s: ", prompts[i]);
    }
    return nameAddressArray;
}