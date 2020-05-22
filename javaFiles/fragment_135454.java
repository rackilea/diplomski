public static int numberIndex(String[] numbers, String target) {
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void totalDuration(String[] phoneNumbers, int[] callDurations, String target) {
        String[] newNumbers = new String[phoneNumbers.length];
        int[] newDurations = new int[callDurations.length];
        int newIndex = 0;

        for(int i = 0; i < phoneNumbers.length; i++) {
            int oldIndex = numberIndex(newNumbers, phoneNumbers[i]);

            if(oldIndex == -1) {
                newNumbers[newIndex] = phoneNumbers[i];
                newDurations[newIndex] = callDurations[i];
                newIndex++;
            }
            else {
                newDurations[oldIndex] += callDurations[i];
            }
        }

        for(int i = 0; i < newIndex; i++) {
            System.out.println("Total duration for " + newNumbers[i] + ": " + newDurations[i]);
        }
    }