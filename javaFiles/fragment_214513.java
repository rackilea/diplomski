# figure out which class to run
if [ "$COMMAND" = "crawl" ] ; then
  CLASS=org.apache.nutch.crawl.Crawl
elif [ "$COMMAND" = "inject" ] ; then
  CLASS=org.apache.nutch.crawl.Injector
elif [ "$COMMAND" = "generate" ] ; then
  CLASS=org.apache.nutch.crawl.Generator
elif [ "$COMMAND" = "freegen" ] ; then
  CLASS=org.apache.nutch.tools.FreeGenerator
elif [ "$COMMAND" = "fetch" ] ; then
  CLASS=org.apache.nutch.fetcher.Fetcher
elif [ "$COMMAND" = "fetch2" ] ; then
  CLASS=org.apache.nutch.fetcher.Fetcher2
elif [ "$COMMAND" = "parse" ] ; then
  CLASS=org.apache.nutch.parse.ParseSegment
elif [ "$COMMAND" = "readdb" ] ; then
  CLASS=org.apache.nutch.crawl.CrawlDbReader
elif [ "$COMMAND" = "convdb" ] ; then
  CLASS=org.apache.nutch.tools.compat.CrawlDbConverter
elif [ "$COMMAND" = "mergedb" ] ; then
  CLASS=org.apache.nutch.crawl.CrawlDbMerger
elif [ "$COMMAND" = "readlinkdb" ] ; then
  CLASS=org.apache.nutch.crawl.LinkDbReader
elif [ "$COMMAND" = "readseg" ] ; then
  CLASS=org.apache.nutch.segment.SegmentReader
elif [ "$COMMAND" = "segread" ] ; then
  echo "[DEPRECATED] Command 'segread' is deprecated, use 'readseg' instead."
  CLASS=org.apache.nutch.segment.SegmentReader
elif [ "$COMMAND" = "mergesegs" ] ; then
  CLASS=org.apache.nutch.segment.SegmentMerger
elif [ "$COMMAND" = "updatedb" ] ; then
  CLASS=org.apache.nutch.crawl.CrawlDb
elif [ "$COMMAND" = "invertlinks" ] ; then
  CLASS=org.apache.nutch.crawl.LinkDb
elif [ "$COMMAND" = "mergelinkdb" ] ; then
  CLASS=org.apache.nutch.crawl.LinkDbMerger
elif [ "$COMMAND" = "index" ] ; then
  CLASS=org.apache.nutch.indexer.Indexer
elif [ "$COMMAND" = "solrindex" ] ; then
  CLASS=org.apache.nutch.indexer.solr.SolrIndexer
elif [ "$COMMAND" = "dedup" ] ; then
  CLASS=org.apache.nutch.indexer.DeleteDuplicates
elif [ "$COMMAND" = "solrdedup" ] ; then
  CLASS=org.apache.nutch.indexer.solr.SolrDeleteDuplicates
elif [ "$COMMAND" = "merge" ] ; then
  CLASS=org.apache.nutch.indexer.IndexMerger
elif [ "$COMMAND" = "plugin" ] ; then
  CLASS=org.apache.nutch.plugin.PluginRepository
elif [ "$COMMAND" = "server" ] ; then
  CLASS='org.apache.nutch.searcher.DistributedSearch$Server'
else
  CLASS=$COMMAND
fi

# run it
exec "$JAVA" $JAVA_HEAP_MAX $NUTCH_OPTS -classpath "$CLASSPATH" $CLASS "$@"