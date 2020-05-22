{
  "script": {
    "source": """
    def creationDate = Instant.parse(ctx._source.creationDate);
    def modifiedDate = Instant.parse(ctx._source.modifiedDate);
    ctx._source.modified = ChronoUnit.MICROS.between(creationDate, modifiedDate) > 0;
    """,
    "lang": "painless"
  },
  "query": {
    "match_all": {}
  }
}