for(loop conditions)
        if (numbers[index] != null && (numbers[index].equals(accnum))) {
            return String.valueOf(index);
            //your text goes here;
        }
        break;//I suggest you take this line out of your original code. Your for loop will end this once you have iterated through the entire array, or you will automatically break out if you find the value.
}