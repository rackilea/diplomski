interface Article { ArticleData getArticleData(); }

final ArticleData {id, name, text}

final NewspaperArticle { articleData, printDate } implements Article

final ScientificArticle { articleData, quotations, publicationDate } implements Article

final ... { articleData, ... } implements Article