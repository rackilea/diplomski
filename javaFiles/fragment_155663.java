@Override
public void onMessage(Message message) {
    try {
        System.out.println(bar.getId());
        System.out.println(bar.getId());
    }
    finally {
        this.scope.clearCache();
    }
}