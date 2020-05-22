public boolean isEven(int number) {
        number = number < 0 ? number * -1 : number;
        if (number < 1) {
            return true;
        }
        if (number > 0 && number < 2) {
            return false;
        }

        return isEven(number - 2);
    }