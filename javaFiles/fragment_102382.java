public <POJO> void asyncServicePOJO(final POJO pojo) {
    executorService.execute(new Runnable() {
        @Override
        public void run() {
            servicePOJO(pojo);
        }
    });
}