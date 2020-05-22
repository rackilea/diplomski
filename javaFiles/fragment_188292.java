class Method { 
    @Override
    public String toString() {
        return "Method [access=" + access + ", type=" + type + ", name=" + name
                + "]";
    }

    Access access; 
    ReturnType type; 
    String name;

    public Method (Access access, ReturnType type, String name) { 
        this.access = access; 
        this.type = type; 
        this.name = name;
    }
}

enum Access {
    Public("public"), 
    Private("private"), 
    Protected("protected");

    private String token;

    Access(String token) { 
        this.token = token; 
    }

    String token() { return token; }
}

enum ReturnType { 
    Void("void"), 
    Integer("integer"), 
    String("string");

    private String token;

    ReturnType(String token) { 
        this.token = token; 
    }

    String token() { return token; }
}

class InvalidCodeException extends Exception {
    private final String message; 

    public InvalidCodeException(String string, Object... params) {
        message = String.format(string, params);
    }

    @Override
    public String getMessage() { 
        return message; 
    }
}

public class MethodParse {
    public static void main(String[] args) throws IOException, InvalidCodeException { 
        System.out.println(methodDeclaration());
    }

    static String tokens = "method public void main()";  
    static StreamTokenizer stream = new StreamTokenizer(new StringReader(tokens));

    static String nameDeclaration() throws IOException, InvalidCodeException { 
        stream.nextToken();
        for (char c : stream.sval.toCharArray()) { 
            if (Character.getType(c) != Character.UPPERCASE_LETTER && 
                Character.getType(c) != Character.LOWERCASE_LETTER) { 
                throw new InvalidCodeException("name expected, found %s", stream.sval);
            }
        }
        return stream.sval;
    }

    static ReturnType returnTypeDeclaration() throws IOException, InvalidCodeException { 
        stream.nextToken();
        for (ReturnType rt : ReturnType.values()) {
            if (rt.token().equals(stream.sval)) {
                return rt; 
            }
        }
        throw new InvalidCodeException("access modifier expected, found %s", stream.sval);
    }

    static Access accessDeclaration() throws IOException, InvalidCodeException { 
        stream.nextToken();
        for (Access a : Access.values()) {
            if (a.token().equals(stream.sval)) {
                return a; 
            }
        }
        throw new InvalidCodeException("access modifier expected, found %s", stream.sval);
    }

    static Method methodDeclaration() throws IOException, InvalidCodeException {
        stream.nextToken(); 

        if (!stream.sval.equals("method")) { 
            throw new InvalidCodeException("method expected, found %s", stream.sval); 
        }

        return new Method(accessDeclaration(), returnTypeDeclaration(), nameDeclaration());
    }
}