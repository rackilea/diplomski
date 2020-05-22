ArrayList<String> urls = new ArrayList<>();
    urls.add("https://lh3.googleusercontent.com/proxy/xdswuBCXXazoCcJ9t9c0y1DqcEU8Ixog4B6Q2MJaE3Iy84VV7g8GOS8C5b9JgTlFRGg23q_Rjw61Tr68A0mJ9ZnoqJdxPLLvCCZteQBOcaW61KEOQA");
    urls.add("https://www.luxuryproperty.com/uploads/images/6-bedroom-villa-for-sale-dubai_hills_mansions-LP0542-9ea75fa49452780.jpg");
    urls.add("https://www.luxuryproperty.com/uploads/images/7-bedroom-villa-for-sale-dubai_hills_mansions-LP0514-261aafdf24310c00.jpg");

    for(int i = 0; i < urls.size(); i++){
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl(urls.get(i));

        // here
        adapter.addItem(sliderItem);
    }