String input = 
    "{\"path\" : \"/gdi/games/2\", \"key\" : \"detail\", \"value\" : {\"id\":\"2\",\"name\":\"game2\"}}," +
    "{\"path\" : \"/gdi/games/4\", \"key\" : \"detail\", \"value\" : {\"id\":\"4\",\"name\":\"game4\"}}," +
    "{\"path\" : \"/gdi/games/6\", \"key\" : \"detail\", \"value\" : {\"id\":\"6\",\"name\":\"game6\"}}";
input = input.replaceAll("(?=\"[^{}]*\\})", "\\\\");
System.out.println(input);