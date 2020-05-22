List<PDFOrder> orders = new ArrayList<>();
    // ... populate orders

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    List<Future<String>> results = new ArrayList<>();

    orders.forEach(o -> {
        // orderID will be used for PDF filename
        PDFTask task = new PDFTask(o.getOrderID());
        results.add(executorService.submit(task));
    });