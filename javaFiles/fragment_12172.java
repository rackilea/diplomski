static Annotation[][] getActualAnnotations(AnnotatedType at, Class<?> target) {
    Type[] typeParameters = target.getTypeParameters();
    if(typeParameters.length==0) return new Annotation[0][];
    Type t=at.getType();
    Map<Type,Annotation[]> atArgAnnos;
    Class<?> raw;
    if(t instanceof Class) {
        atArgAnnos=Collections.emptyMap();
        raw=(Class<?>)t;
        if(raw==target) return new Annotation[typeParameters.length][0];
    }
    else if(t instanceof ParameterizedType) {
        ParameterizedType pt=(ParameterizedType)t;
        raw=(Class<?>)pt.getRawType();
        Type[] param=raw.getTypeParameters();
        Annotation[][] a = Arrays
            .stream(((AnnotatedParameterizedType)at).getAnnotatedActualTypeArguments())
            .map(AnnotatedType::getAnnotations)
            .toArray(Annotation[][]::new);
        if(raw==target) return a;
        atArgAnnos=new HashMap<>(a.length);
        for(int ix = 0; ix < a.length; ix++)
            atArgAnnos.put(param[ix], a[ix]);
    }
    else throw new UnsupportedOperationException(
            "type variables, wildcard or arrays are not supported");
    raw.asSubclass(target);// throws if not assignable
    for(AnnotatedType aift: target.isInterface()? raw.getAnnotatedInterfaces():
                            new AnnotatedType[]{raw.getAnnotatedSuperclass()}) {
        Type ift=aift.getType();
        if(ift==target) return new Annotation[typeParameters.length][0]; // raw
        else {
            AnnotatedParameterizedType ifpt = (AnnotatedParameterizedType)aift;
            if(((ParameterizedType)ifpt.getType()).getRawType()!=target) continue;
            return Arrays.stream(ifpt.getAnnotatedActualTypeArguments())
                  .map(ta -> atArgAnnos.getOrDefault(ta.getType(), ta.getAnnotations()))
                  .toArray(Annotation[][]::new);
        }
    }
    throw new UnsupportedOperationException(
        t.getTypeName()+" does not (directly) extend or implement "+target);
}