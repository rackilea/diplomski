static class MyParser extends JsonParserDelegate {
    MyParser(final JsonParser delegate) {
        super(delegate);
    }

    @Override
    public String getText() throws IOException {
        final String text = super.getText();

        if ("name".equals(getCurrentName())) {
            return text + "-3";
        }

        return text;
    }

    @Override
    public JsonToken nextToken() throws IOException {
        if ("price".equals(getCurrentName())) {
            // Advance token anyway
            super.nextToken();
            return JsonToken.VALUE_NUMBER_FLOAT;
        }

        return super.nextToken();
    }

    @Override
    public int getCurrentTokenId() {
        try {
            if ("price".equals(getCurrentName())) {
                return JsonTokenId.ID_NUMBER_FLOAT;
            }
        } catch (final IOException e) {
            //
        }

        return super.getCurrentTokenId();
    }

    @Override
    public NumberType getNumberType() throws IOException {
        if ("price".equals(getCurrentName())) {
            return NumberType.FLOAT;
        }

        return super.getNumberType();
    }

    @Override
    public float getFloatValue() throws IOException {
        return Float.parseFloat(getValueAsString("0")) + 0.09F;
    }

    @Override
    public double getDoubleValue() throws IOException {
       return Double.parseDouble(getValueAsString("0")) + 0.09D;
    }
}