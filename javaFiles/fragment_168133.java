ModelMapper modelMapper = new ModelMapper();
modelMapper.getConfiguration().setDeepCopyEnabled(true); // this triggers the problem

// the converter resolves it
Converter<Base, Base> baseBaseConverter = context ->
        modelMapper.map(context.getSource(), context.getSource().getClass());

modelMapper.createTypeMap(Base.class, Base.class).setConverter(baseBaseConverter);