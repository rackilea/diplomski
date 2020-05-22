private void calculateArea(Region region) {

        RegionIterator regionIterator = new RegionIterator(region);

        int size = 0; // amount of Rects
        float area = 0; // units of area

        Rect tmpRect= new Rect(); 

        while (regionIterator.next(tmpRect)) {
            size++;
            area += tmpRect.width() * tmpRect.height();
        }

        log.d("Rect amount=" + size);
        log.d("Area Size / units of area=" + area);
}