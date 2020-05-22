String uri = "https://jsonplaceholder.typicode.com/posts";
    Class vo = Post[].class;

    Object retorno = restService.get(uri, vo);
    if (retorno.getClass().isArray()) {
        for (int i = 0; i < Array.getLength(retorno); i++) {
            Post post = (Post) Array.get(retorno, i);
            System.out.println(post.getTitle());
        }
    }