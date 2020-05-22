public void add(String name, String url) {
    //code to retrieve your arraylist stored in SharedPrefs
    TinyDB tinydb = new TinyDB(getApplicationContext());
    ArrayList<Object> postObjects = tinydb.getListObject("fav", Post.class);
    ArrayList<Post> myfav = new ArrayList<Post>();
    for(Object objs : postObjects){
        myfav.add((Post)objs);
    }
        Post post = new Post();
        post.setImgUrl(url);
        post.setName(name);
        myfav.add(post);
        tinydb.putListObject("fav", myfav);
        Toast.makeText(getApplicationContext(), "added to fav", Toast.LENGTH_SHORT).show();
 }