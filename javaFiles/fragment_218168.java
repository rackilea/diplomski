ParseUtil.registerStringParser(File.class, new IStringParser<File>() {
    @Override
    public File parse(String s)throws ParseException {
        return new File(s);
    }
});