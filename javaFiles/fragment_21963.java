public static void main(String eth[]) {
        int[] numbers = new int[] {1, 2, 2, 3, 3, 4, 4, 5, 5, 10, 12, 33};
        int[] modes = mode(numbers);

        for (int i = 0; i < modes.length; i++) {
            if (modes[i] == -999) { // Stop printing once you reach the first sentinal value
                continue;
            }
            System.out.println(modes[i]);
        }
    }

    private static int[] mode(int[] numbers) {
        Modes[] modes = new Modes[numbers.length];
        int modesIndex = 0;

        int maxOccurrence = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == -999) {
                continue;
            }

            int number = numbers[i];
            numbers[i] = -999; // -999 is a sentinel value

            int count = 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == -999) {
                    continue;
                }

                if (numbers[j] == number) {
                    numbers[j] = -999;
                    count++;
                }
            }
            if (count > maxOccurrence) {
                maxOccurrence = count;
            }
            modes[modesIndex++] = new Modes(number, count);
        }

        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -999; // Sentinel value
        }

        int index = 0;
        for (int i = 0; i < modes.length; i++) {
            if (modes[i] == null) {
                break; // Stop when you hit the first null
            }
            if (modes[i].Occurrences == maxOccurrence) {
                result[index] = modes[i].Number;
                index++;
            }
        }

        return result;
    }

    public static class Modes {
        public int Number;
        public int Occurrences;

        public Modes(int number, int occurrences) {
            Number = number;
            Occurrences = occurrences;
        }
    }