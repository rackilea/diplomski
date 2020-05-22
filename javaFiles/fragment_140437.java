List<Data> data = datalist.stream()
        .filter(Objects::nonNull)
        .filter(o -> Objects.nonNull(o.getX()) && o.getX().equals(data.getX()))
        .filter(o -> Objects.nonNull(o.getY()) && Objects.nonNull(data.getMwSchemeCode()) && o.getY().equals(data.getMwSchemeCode().getY()))
        .filter(o -> Objects.nonNull(o.getZ()) && o.getZ().eqauls(data.getZ()))
        .collect(Collectors.toList());