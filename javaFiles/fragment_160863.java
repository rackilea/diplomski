Object o = getServletContext().getAttribute("blogpost");

    if( o instanceof ArrayList) {
        List blogList = (ArrayList) o;
        for(Object blog : blogList){
            BlogPost blogPost = (BlogPost) blog;
            System.out.println(blogPost.getBlogtext());
        }
    }