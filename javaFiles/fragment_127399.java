enum PhoneType {
    CELL, WORK, HOME; // in order of preference
}

class Phone {
    public PhoneType getType() ...
    public String getNumber() ...
}

Comparator<Phone> preferredNumber = Comparator.comparing(Phone::getType);

Phone best = phoneList.stream().min(preferredNumber).orElseThrow();