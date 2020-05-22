for (final StockListBean stockListBean : list) {
    final int code = stockListBean.getCode(); // assuming int, change as required
    final Task<Float> task = new Task<Float>() {
        @Override
        protected Float call() throws Exception {
            logger.debug("In jfx task for {}", code);
            return stocksListMService.getActualPrice(code);
        }
    };
    task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
        @Override
        public void handle(WorkerStateEvent event) {
            ((StockListRunningBean)stockListBean).setActualPrice(task.getValue());
        }
    });
    executor.execute(task);
}