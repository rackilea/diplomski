public class PhoneBook {

    private Map<String, String> namesToNumbers = new HashMap<>();
    private Map<String, String> numbersToNames = new HashMap<>();

    public void insertEntry(String name, String phoneNumber) {
        namesToNumbers.put(name, phoneNumber);
        numbersToNames.put(phoneNumber, name);
    }

    public String getNameForPhoneNumber(String phoneNumber) {
        return numbersToNames.get(phoneNumber);
    }

    public String getPhoneNumberForName(String name) {
        return namesToNumbers.get(name);
    }

    public void removeEntryByPhoneNumber(String phoneNumber) {
        String name = numbersToNames.get(phoneNumber);
        namesToNumbers.remove(name);
        numbersToNames.remove(phoneNumber);
    }

    public void removeEntryByName(String name) {
        String phoneNumber = namesToNumbers.get(name);
        numbersToNames.remove(phoneNumber);
        namesToNumbers.remove(name);
    }
}