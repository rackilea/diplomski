Article article = Article.findById(1);
article.add(Comment.create("author", "tjefferson", "content", "comment 1"));
article.add(Comment.create("author", "tjefferson", "content", "comment 2"));
LazyList<Comment> comments = Comment.where("author = ?", "tjefferson").include(Article.class);

System.out.println(comments.size());// does loading of data, prints 2
Article parent1 = comments.get(0).parent(Article.class); // does not generate DB query
Article parent2 = comments.get(1).parent(Article.class); // does not generate DB query

assert (parent1 == parent2); // true