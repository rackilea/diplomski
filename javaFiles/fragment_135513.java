/* int SecKeychainFindGenericPassword(
 *     Pointer keychainOrArray,
 *     int serviceNameLength,
 *     String serviceName,
 *     int accountNameLength,
 *     String accountName,
 *     IntByReference *passwordLength,
 *     PointerByReference passwordData,
 *     PointerByReference itemRef
 * );
 */

static void main() {
    IntByReference passLength = new IntByReference(0);
    PointerByReference passwordData = new PointerByReference();
    PointerByReference itemRef = new PointerByReference();

    int result = SecKeychainFindGenericPassword(
        keychainOrArray,
        "service name".length(),
        "service name",
        "account".length(),
        "account",
        passLength,
        passwordData,
        itemRef
    );

    if (result == 0) {
        System.out.printf(
            "OSStatus: %d, passDataPtr: 0x%08X, itemRefPtr: 0x%08X%n",
            result,
            Pointer.nativeValue(passwordData.getValue()),
            Pointer.nativeValue(itemRef.getValue())
        );
    } else {
        /* Use SecCopyErrorMessageString to get a human-readable message */
        System.out.printf("An error occurred: %d%n", result);
    }
}