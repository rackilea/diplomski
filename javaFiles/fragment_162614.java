main.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return canScroll && super.canScrollVertically();
            }
        });