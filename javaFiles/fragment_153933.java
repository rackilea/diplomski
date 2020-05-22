Class<?> aClass = t.getClass();
    Object result = aClass.newInstance();
    Map<String,MethodHolder> map=new HashMap<>();
    for (Method method : aClass.getMethods()) {
        if(method.getName().startsWith("get") && method.getParameterTypes().length==0){
            String property=method.getName().substring(3);
            MethodHolder hodler = map.get(property);
            if(hodler ==null){
                map.put(property, new MethodHolder(property, method, null));
                continue;
            }
            hodler.getMethod=method;
        }else if (method.getName().startsWith("set") && method.getParameterTypes().length==1) {
            String property=method.getName().substring(3);
            MethodHolder holder = map.get(property);
            if(holder ==null){
                map.put(property, new MethodHolder(property, null, method));
                continue;
            }
            holder.setMethod=method;
        }
    }
    List<MethodHolder> collect = map.values().stream().filter(item -> item.setMethod != null && item.getMethod != null).collect(Collectors.toList());
    for (MethodHolder holder : collect) {
        Object property = holder.getMethod.invoke(t);
        holder.setMethod.invoke(result,property);
    }
    return (T)result;