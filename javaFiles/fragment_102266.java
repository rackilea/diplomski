private static HeartRateListener heartRateListener;
        public static void setHeartRateListener(HeartRateListener listener){
            heartRateListener = listener;
        }
public static interface HeartRateListener{
            void onHeartRate(int yourValue);
}

    // Send your continuously updated value
        heartRateListener.onHeartRate(yourValue);