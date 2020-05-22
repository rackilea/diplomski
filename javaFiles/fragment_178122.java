runOnUiThread(new Runnable() {
    @Override
    public void run() {
        Toast.makeText(WeatherActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
});