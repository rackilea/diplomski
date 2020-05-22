private void validateWords() {
        int length = string.get(0).length();

        for (int j = 0; j < string.size(); j++) {

            if (string.get(j).length() != length) {
                throw new InvalidRadixSortException("Invalid String Length");
            }

            if (!string.get(j).matches("[a-zA-Z]+")) {
                throw new InvalidRadixSortException("Contains Non-Letters");
            }
        }
    }