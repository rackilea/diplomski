$solr = new Apache_Solr_Client(...);

$searchOptions = array(
  'sort' => 'mod_date desc'
);

$results = $solr->search("bmw", 0, 10, $searchOptions);