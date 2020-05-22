float value1 = 12.0f;
    float value2 = 123123123;

    BeanItem<Float> item1 = new BeanItem<Float>(value1);
    BeanItem<Float> item2 = new BeanItem<Float>(value2);

    System.out.println(" result 1: " + item1.getBean());
    System.out.println(" result 2: " + item2.getBean());