List<Interface> list = allACFs.stream().sorted(new Comparator<Interface>() {
    @Override
    public int compare(Interface o1, Interface o2) {
        System.out.println(o1.getType().getCode()+" : "+o2.getType().getCode()+" > "+o1.getType().getCode().compareTo(o2.getType().getCode()));
        return o1.getType().getCode().compareTo(o2.getType().getCode());
    }
}).collect(Collectors.toList());