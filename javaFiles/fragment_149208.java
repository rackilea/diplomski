CREATE CUSTOM INDEX fn_suffix_allcase ON cyclist_name (firstname) 
USING 'org.apache.cassandra.index.sasi.SASIIndex'
WITH OPTIONS = { 
  'mode': 'CONTAINS',
  'analyzer_class':'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer',
  'case_sensitive': 'false'
};