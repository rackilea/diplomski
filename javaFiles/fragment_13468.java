JSONSerializer serializer = new JSONSerializer().transform( new AbstractTransformer() {
        @Override
        public void transform(Object object) {

            String value = object.toString();
            int len = value.length();
            StringBuilder stringBuilder = new StringBuilder("\"");
            for (int i = 0; i < len; i++) {
                char c = value.charAt( i );
                if (c == '"') {
                    stringBuilder.append( "\\u0022" );
                } else if (c == '&') {
                    stringBuilder.append( "\\u0026" );
                } else if (c == '\'') {
                    stringBuilder.append( "\\u0027" );
                } else if (c == '\\') {
                    stringBuilder.append( "\\\\" );
                } else if (c == '\b') {
                    stringBuilder.append( "\\b" );
                } else if (c == '\f') {
                    stringBuilder.append( "\\f" );
                } else if (c == '\n') {
                    stringBuilder.append( "\\n" );
                } else if (c == '\r') {
                    stringBuilder.append( "\\r" );
                } else if (c == '\t') {
                    stringBuilder.append( "\\t" );
                } else if (c > 127) {
                    stringBuilder.append( "\\u" );
                    int n = c;
                    for (int j = 0; j < 4; ++j) {
                        int digit = (n & 0xf000) >> 12;
                        stringBuilder.append( String.valueOf( JSONSerializer.HEX[digit] ) );
                        n <<= 4;
                    }
                } else {
                    stringBuilder.append( c );
                }
            }
            stringBuilder.append( "\"" );
            getContext().write( stringBuilder.toString() );
        }
    }, String.class );