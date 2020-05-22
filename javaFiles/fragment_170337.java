if (stack == null) {
    if (Build.VERSION.SDK_INT >= 9) {
        stack = new HurlStack();
    } else {
        stack = new MyHttpClientStack(AndroidHttpClient.newInstance(userAgent));
    }
}

Network network = new BasicNetwork(stack);