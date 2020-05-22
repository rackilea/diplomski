public static String[] getNullPropertyNames (Object source, Object target) {
    final BeanWrapper src = new BeanWrapperImpl(source);
    final BeanWrapper targetBean = new BeanWrapperImpl(target);
    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
    Set<String> emptyNames = new HashSet<String>();
    for(java.beans.PropertyDescriptor pd : pds) {
        Object srcValue = src.getPropertyValue(pd.getName());
        if (srcValue == null) {
            emptyNames.add(pd.getName());
        }else  {
            Class<?> accessor = src.getPropertyType(pd.getName());
            String cname = accessor.getCanonicalName();
            if(cname.contains("com.demo.test")) {
                Object targetVal = targetBean.getPropertyValue(pd.getName());
               if(targetVal  != null) {
                BeanUtils.copyProperties(srcValue,targetVal , getNullPropertyNames(srcValue,targetVal));
                emptyNames.add(pd.getName());
                  }
            }
        }
    }

    String[] result = new String[emptyNames.size()];
    return emptyNames.toArray(result);
}