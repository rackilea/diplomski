final CarouselLayoutManager layoutManager = new 
CarouselLayoutManager(CarouselLayoutManager.VERTICAL);

final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
recyclerView.setLayoutManager(layoutManager);
recyclerView.setHasFixedSize(true);