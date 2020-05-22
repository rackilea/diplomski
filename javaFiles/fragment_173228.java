class Apple {
    private AppleHolder appleHolder;

    public AppleHolder getAppleHolder() {
        return this.appleHolder;
    } 

    // Rest of class...
}

class AppleHolder {
    private Apple apple;

    private AppleHolder(Apple apple) {
        this.apple = apple;
    }

    public static AppleHolder getAppleHolder(Apple apple) {
        if(apple.getAppleHolder() != null) {
            return apple.getAppleHolder();
        } else {
            return new AppleHolder(apple);
        }
    }
}