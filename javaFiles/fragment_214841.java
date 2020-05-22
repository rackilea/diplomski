public static void copyProperties2(Object src, Object trg, Set<String> props) {
    String[] excludedProperties = 
            Arrays.stream(BeanUtils.getPropertyDescriptors(src.getClass()))
                  .map(PropertyDescriptor::getName)
                  .filter(name -> !props.contains(name))
                  .toArray(String[]::new);

    BeanUtils.copyProperties(src, trg, excludedProperties);
}