private Date lastChecked = Calendar.getInstance().getTime();
    private ConnectableFlux<Object> flux;

    @PostConstruct
    public void load()
    {
        System.out.println("Loaded");
        this.flux = Flux.create(fluxSink -> {
            String uniqueID = UUID.randomUUID().toString();
            Flux.interval(Duration.ofSeconds(1))
                .map(s -> {
                    System.out.println(uniqueID);
                    this.newsRepository.findByTimestampGreaterThanOrderByTimestampDesc(lastChecked).take(5).doOnEach(new Consumer<Signal<News>>() {
                        @Override
                        public void accept(Signal<News> commentSignal) {
                            fluxSink.next(commentSignal.get());
                        }
                    }).subscribe();
                    lastChecked = Calendar.getInstance().getTime();
                    lastChecked.setTime(lastChecked.getTime() - 2000);
                    return s;
                })
                .subscribe();
        }).publishOn(Schedulers.parallel())
            .onBackpressureBuffer()
            .publish();
    }

    @GetMapping(path = "/news/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Object> comments(@RequestParam(required=false) String date) throws ParseException {

        return flux.autoConnect();
    }