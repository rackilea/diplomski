$searchOptions = array(
    'fq' => 'category:"Bilar" + car_action:Sälje',
    'sort' => 'mod_date desc'
)

$solr->search("\*:*", 0, 10, $searchOptions);