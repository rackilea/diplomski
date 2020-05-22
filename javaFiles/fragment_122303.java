for(int i = 0; i < this.digits.length; i++) {
        if(this.digits[i] < that.digits[i]) {
            return -1;
        }
        if(that.digits[i] < this.digits[i]) {
            return 1;
        }
    }