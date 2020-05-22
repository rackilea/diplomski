class Counter {
    // name
    long bothStudentsHaveName;
    long onlyLeftHasName;
    long onlyRightHasName;
    // address
    long bothStudentsHaveAddress;
    long onlyLeftHasAddress;
    long onlyRightHasAddress;
    // biologyCourse
    long bothStudentsHaveBiologyCourse;
    long onlyLeftHasBiologyCourse;
    long onlyRightHasBiologyCourse;
    // ... and so on


    @Override
    public String toString() {
        return "Counter{" + "\n" +
                "\tbothStudentsHaveName = " + bothStudentsHaveName + "\n" +
                "\t, onlyLeftHasName = " + onlyLeftHasName + "\n" +
                "\t, onlyRightHasName = " + onlyRightHasName + "\n" +
                "\t, bothStudentsHaveAddress = " + bothStudentsHaveAddress + "\n" +
                "\t, onlyLeftHasAddress = " + onlyLeftHasAddress + "\n" +
                "\t, onlyRightHasAddress = " + onlyRightHasAddress + "\n" +
                "\t, bothStudentsHaveBiologyCourse = " + bothStudentsHaveBiologyCourse + "\n" +
                "\t, onlyLeftHasBiologyCourse = " + onlyLeftHasBiologyCourse + "\n" +
                "\t, onlyRightHasBiologyCourse = " + onlyRightHasBiologyCourse + "\n" +
                '}';
    }
}