private static boolean internetConnectionAvailable;
private static ScheduledExecutorService scheduleTaskExecutor;


public static void stopInternetMonitor() {
    if (scheduleTaskExecutor != null && !scheduleTaskExecutor.isShutdown()) {
        scheduleTaskExecutor.shutdown();
    }
}

public static void startInternetMonitor() {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            isInternetConnectionAvailableSync();
        }
    };

    if (scheduleTaskExecutor != null) {
        if (scheduleTaskExecutor.isShutdown()) {
            scheduleTaskExecutor.scheduleWithFixedDelay(runnable, 0, 30, TimeUnit.SECONDS);
        }
    } else {
        scheduleTaskExecutor = Executors.newScheduledThreadPool(5);
        scheduleTaskExecutor.scheduleWithFixedDelay(runnable, 0, 30, TimeUnit.SECONDS);
    }
}

public static boolean isInternetConnectionAvailableCached() {

    ConnectivityManager cm = (ConnectivityManager) FashionTrenderApplication.getInstance()
            .getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    if (activeNetwork != null && activeNetwork.isConnected() && internetConnectionAvailable) {
        return true;
    }

    return false;
}

public static boolean isInternetConnectionAvailableSync() {
    ConnectivityManager cm = (ConnectivityManager) FashionTrenderApplication.getInstance()
            .getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    if (activeNetwork != null && activeNetwork.isConnected()) {
        try {
            URL url = new URL(EnvironmentConfiguration.getInstance().getServerUrl());
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestProperty("User-Agent", "test");
            urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(1000); // mTimeout is in seconds
            urlc.connect();
            if (urlc.getResponseCode() == 200) {
                internetConnectionAvailable = true;
                return true;
            } else {
                internetConnectionAvailable = false;
                return false;
            }
        } catch (IOException e) {
            Log.i("warning", "Error checking internet connection", e);
            return false;
        }
    }

    return false;
}