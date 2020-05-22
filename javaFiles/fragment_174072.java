try(IntStream is=IntStream.range(0, 100).onClose(()->System.out.println("done"))) {
    is.parallel().forEach(x -> {
        System.out.println(x);
        if(Math.random()>0.7) throw new RuntimeException();
    });
}