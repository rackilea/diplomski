Set<Post> posts = new TreeSet<>();
for (Course course : courses) {
    posts.addAll(course.getPosts());
}

List<Post> postList = new ArrayList<>(posts);
Collections.reverse(postList);

model.addAttribute("posts", postList);